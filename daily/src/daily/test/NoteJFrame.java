package daily.test;

import daily.entity.Daily;
import daily.test.AddJFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

// 每日一记主界面
public class NoteJFrame extends JFrame implements ActionListener {
    // 无参构造方法
    public NoteJFrame() {
        // 初始化每日一记主界面
        initFrame();
        // 初始化界面菜单
        initJMenuBar();
        // 初始化界面组件
        initView();
        // 将界面显示出来
        this.setVisible(true);
    }

    // 创建表格对象
    JTable table;
    // 创建添加、修改、删除三个按钮对象
    JButton insert = new JButton("添加");
    JButton update = new JButton("修改");
    JButton delete = new JButton("删除");


    // 创建二维数组，用于存储表格中的每一行数据
    public static Object[][] tableDatas = null;

    // 初始化界面组件
    private void initView() {
        // 1.设置大标题：每日一记
        // 创建JLabel容器用于管理文字：每日一记
        JLabel title = new JLabel("每日一记");
        // 设置大标题的坐标位置
        title.setBounds(265, 20, 500, 40);
        // 设置大标题的字体样式
        title.setFont(new Font("宋体", Font.BOLD, 32));
        // 将大标题：每日一记放到界面的隐藏容器中
        this.getContentPane().add(title);

        // 2.设置表格
        // 创建一维数组，用于存储表格的标题
        Object[] tableTitles = {"编号", "标题", "正文"};
        tableDatas = new Object[10000][3];
        // 设置表格内容及坐标
        table = new JTable(tableDatas, tableTitles);
        table.setBounds(90, 70, 500, 500);

        //创建可滚动的组件，并把表格组件放在滚动组件中间
        //好处：如果表格中数据过多，可以进行上下滚动
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(90, 70, 500, 400);
        this.getContentPane().add(jScrollPane);

        // 3.读取日记对象
        // 创建日记存储文档的文件夹对象
        File file = new File("data");
        getFileDatas(file);

        // 3.设置添加、修改、删除三个按钮的坐标与宽高、字体样式
        insert.setBounds(90, 500, 100, 40);
        update.setBounds(290, 500, 100, 40);
        delete.setBounds(490, 500, 100, 40);

        insert.setFont(new Font("宋体", Font.PLAIN, 24));
        update.setFont(new Font("宋体", Font.PLAIN, 24));
        delete.setFont(new Font("宋体", Font.PLAIN, 24));

        // 给三个按钮绑定点击事件
        insert.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);

        // 将添加、修改、删除三个按钮放进界面的隐藏容器中
        this.getContentPane().add(insert);
        this.getContentPane().add(update);
        this.getContentPane().add(delete);
    }

    /**
     * 获取文件夹中的所有文件数据
     */
    private void getFileDatas(File src) {
        // 得到文件夹下所有的日记存储文档的数组
        File[] files = src.listFiles();
        // 遍历数组，依次得到所有日记文档的路径
        for (int i = 0; i < files.length; i++) {
            // 判断是文件还是文件夹
            if (files[i].isFile()) {
                // 是文件
                try {
                    // 反序列化
                    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(files[i]));
                    // 依次读取每一个日记文档（返回一个反序列化的日记对象）
                    Daily daily = (Daily) ois.readObject();
                    // 关闭流
                    ois.close();

                    // 依次给二维数组中的每一个一维数组添加元素（添加行数据）
                    tableDatas[i][0] = daily.getID();
                    tableDatas[i][1] = daily.getTitle();
                    tableDatas[i][2] = daily.getContent();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            } else {
                // 是文件夹：递归
                getFileDatas(files[i]);
            }
        }
    }

    // 创建功能的导入和导出
    JMenuItem importItem = new JMenuItem("导入");
    JMenuItem exportItem = new JMenuItem("导出");

    // 初始化界面菜单
    private void initJMenuBar() {
        // 创建整个的菜单对象
        JMenuBar jMenuBar = new JMenuBar();
        // 创建菜单下的选项对象：功能
        JMenu functionJMenu = new JMenu("功能");

        // 将导入和导出这两个栏目放进功能菜单下
        functionJMenu.add(importItem);
        functionJMenu.add(exportItem);
        // 将功能菜单放进整个的菜单中
        jMenuBar.add(functionJMenu);

        // 给导入和导出绑定点击事件
        importItem.addActionListener(this);
        exportItem.addActionListener(this);

        // 给菜单设置背景颜色
        jMenuBar.setBackground(new Color(197, 197, 197));

        // 将菜单设置到界面中
        this.setJMenuBar(jMenuBar);
    }


    // 初始化每日一记主界面
    private void initFrame() {
        // 设置界面的宽高
        this.setSize(700, 700);
        // 设置界面的标题
        this.setTitle("每日一记");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // 取消默认的居中位置，只有取消了才会按照x、y轴的形式添加组件
        this.setLayout(null);
        // 设置界面的背景颜色
        this.getContentPane().setBackground(new Color(204, 238, 200));
    }

    // 监听点击事件
    @Override
    public void actionPerformed(ActionEvent e) {
        // 获取当前被点击的对象
        Object obj = e.getSource();
        // 判断是哪个组件对象被点击了
        if (obj == insert) {
            System.out.println("添加按钮被点击");
            // 关闭当前界面后，跳转到添加日记的界面
            this.setVisible(false);
            new AddJFrame();

        } else if (obj == update) {
            System.out.println("修改按钮被点击");
            // 情况1：如果没有选中某条数据，直接点击修改，则提示：未选中要修改的行，请重试
            // 获取选中的是哪条数据：二维数组中元素的索引
            int i = table.getSelectedRow();

            // 如果i小于0
            if (i < 0) {
                showJDialog( "未选中要修改的行，请重试");
                return;
            }

            // 情况2：如果选中了某条数据，但是是空的，则提示：已没有可修改的行，请重试
            Object daily = tableDatas[i][0];
            if (daily == null) {
                showJDialog( "该行没有数据可修改，请重试");
                return;
            }

            // 情况3：如果选中了某条数据，是存在的，则关闭当前界面后，跳转到修改日记的界面
            this.setVisible(false);
            // 传递被选中的日记的编号给修改构造方法
            new UpdateJFrame((int) daily);

        } else if (obj == delete) {
            System.out.println("删除按钮被点击");
            // 情况1：如果没有选中某条数据，直接点击删除，则提示：未选中要删除的行，请重试
            int i = table.getSelectedRow();
            // 如果i小于0
            if (i < 0) {
                showJDialog( "未选中要删除的行，请重试");
                return;
            }

            // 情况2：如果选中了某条数据，但是是空的，则提示：已没有可删除的行，请重试
            Object daily = tableDatas[i][0];
            if (daily == null) {
                showJDialog( "该行没有数据可删除，请重试");
                return;
            }

            // 情况3：如果选中了某条数据，点击删除后，提示：是否要删除选中的数据
            // 获取被选中的日记文档的序号
            int ID = (int) daily;
            // 弹出一个提示框
            int num = showChooseJDialog();
            // 如果选择是，则删除，否则不做任何操作
            if (num == 0) {
                // 删除
                File file = new File("data\\data" + ID + ".txt");
                file.delete();
                // 刷新主界面
                this.setVisible(false);
                new NoteJFrame();
            }
        } else if (obj == importItem) {
            System.out.println("导入功能被点击");
            // 解压文件夹
            // 点击导入时，默认将桌面上的data.zip压缩包解压，获取里面所有的数据展示出来
            // 1.创建File对象src，表示要解压的压缩包
            File src = new File("C:\\临时\\data.zip");
            // 2.创建File对象dest，表示解压后的文件的去处
            File dest = new File("data");
            // 3.判断src路径是否不存在
            if (!src.exists()) {
                showJDialog( "data.zip不存在，请重试！");
                return;
            }

            try {
                // 4.解压
                unzip(src, dest);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        } else if (obj == exportItem) {
            System.out.println("导出功能被点击");
            // 压缩文件夹（压缩流）
            // 需求：点击导出时，将所有日记文件打包成压缩包放到桌面上压缩包名为data.zip
            // 0.判断是否没有日记可以导出
            if (tableDatas[0][0] == null) {
                showJDialog("没有日记可以导出，请重试！");
                return;
            }

            // 1.创建File对象表示要压缩的文件夹
            File src = new File("data");
            // 2.创建File对象表示文件夹压缩后放在哪里
            File dest = new File("E:\\临时\\");

            // 3.创建File对象表示压缩包的路径
            File zipSrc = new File(dest, src.getName() + ".zip");
            try {
                // 4.创建压缩流关联压缩包
                ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipSrc));
                // 5.将指定文件夹下的所有文件进行压缩
                toZip(src, zos, src.getName());
                // 关闭流
                zos.close();
                showJDialog("成功导出所有日记到电脑桌面");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * 解压zip格式的压缩包
     *
     * @param src  数据源：要解压的压缩包
     * @param dest 目的地：解压后文件或文件夹的去处
     */
    private void unzip(File src, File dest) throws IOException {
        // 解压本质：把压缩包里面的每一个文件或文件夹读取出来，按照层级拷贝到目的地中
        // 1.创建一个解压缩流对象，用于读取压缩包中的数据
        ZipInputStream zip = new ZipInputStream(new FileInputStream(src));

        /*// 获取压缩包文件名（包括后缀）
        String srcName = src.getName();
        // 2.创建目的地目录
        File destDir = new File(dest, srcName.substring(0, srcName.indexOf(".")));
        destDir.mkdirs();*/

        // 3.要先获取到压缩包中的每一个ZipEntry对象
        // 表示在当前压缩包中获取到的文件或文件夹
        ZipEntry entry;
        while ((entry = zip.getNextEntry()) != null) {
            // 3.判断zipEntry是否为文件夹
            if (entry.isDirectory()) {
                // 文件夹：需要在目的地dest处创建一个同样的文件夹
                File file = new File(dest, entry.toString());
                file.mkdirs();
            } else {
                // 文件：需要读取到压缩包中的文件，并将该文件存放到目的地dest文件夹中（按照层级目录进行存放）
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                // 按照1个字节数组读取文件中的数据
                byte[] suffer = new byte[4096];
                int len;
                while ((len = zip.read(suffer)) != -1) {
                    // 写到目的地
                    fos.write(suffer, 0, len);
                }
                fos.close();
                // 表示在压缩包中的一个文件处理完毕了！
                zip.closeEntry();
            }
        }

        // 压缩包中所有的文件或文件夹处理完毕！关闭
        zip.close();
        // 刷新主界面
        this.setVisible(false);
        new NoteJFrame();
    }

    /**
     * 将文件夹打包成一个压缩包
     *
     * @param src  要压缩的文件夹
     * @param zos  压缩流
     * @param name 压缩包内部的路径
     */
    private void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        // 压缩本质：把每一个文件或文件夹放到压缩包中
        // 1.判断要压缩的文件夹路径是否不存在
        if (!src.exists()) {
            showJDialog( "该路径不存在，请重试");
            return;
        }

        // 2.获取所有文件或文件夹
        File[] files = src.listFiles();

        // 3.遍历files数组，依次得到每一个文件或文件夹
        for (File file : files) {
            // 判断file是否为文件
            if (file.isFile()) {
                // 是文件：将该文件变成ZipEntry对象，并放到压缩包中
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                zos.putNextEntry(entry);
                // 依次读取每一个文件的数据，写入到压缩包中
                FileInputStream fis = new FileInputStream(file);
                byte[] buffer = new byte[4096];
                int len;
                while ((len = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, len);
                }
                // 关闭流
                fis.close();
                // 表示一个文件已处理完毕
                zos.closeEntry();
            }
        }
    }

    /*
        因为展示弹框的代码，会被运行多次
        所以，我们把展示弹框的代码，抽取到一个方法中。以后用到的时候，就不需要写了
        直接调用就可以了。
        展示弹框
     */
    private void showJDialog(String path, String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(270, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建JLabel对象管理图片并添加到弹框当中
        JLabel warningIma = new JLabel();
        warningIma.setBounds(165, -25, 200, 150);
        warningIma.setIcon(new ImageIcon(path));
        jDialog.getContentPane().add(warningIma);
        //创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    // 展示弹框
    private void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(270, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建JLabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    /*
     *  作用：展示一个带有确定和取消按钮的弹框
     *
     *  方法的返回值：
     *       0 表示用户点击了确定
     *       1 表示用户点击了取消
     *       该弹框用于用户删除时候，询问用户是否确定删除
     * */
    public int showChooseJDialog() {
        return JOptionPane.showConfirmDialog(this, "是否删除选中数据？", "删除信息确认", JOptionPane.YES_NO_OPTION);
    }
}
