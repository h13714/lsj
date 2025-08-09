package daily.test;

import daily.entity.Daily;
import cn.hutool.core.io.IoUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// 添加日记界面
public class AddJFrame extends JFrame implements ActionListener {
    public AddJFrame() {
        // 初始化添加日记界面
        initFrame();
        // 初始化界面组件
        initView();
        // 将界面显示出来
        this.setVisible(true);
    }

    // 创建标题输入框
    JTextField titleText = new JTextField();
    // 创建正文内容的输入区域
    JTextArea contentText = new JTextArea();
    // 创建保存和取消按钮
    JButton save = new JButton("保存");
    JButton cancel = new JButton("取消");

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

        // 2.设置文字：标题
        JLabel subject = new JLabel("标题");
        subject.setBounds(70, 70, 100, 30);
        subject.setFont(new Font("宋体", Font.PLAIN, 16));
        this.getContentPane().add(subject);
        // 设置标题的输入框
        titleText.setBounds(120, 70, 430, 30);
        titleText.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(titleText);

        // 3.设置文字：内容
        JLabel content = new JLabel("内容");
        content.setBounds(70, 130, 100, 30);
        content.setFont(new Font("宋体", Font.PLAIN, 16));
        this.getContentPane().add(content);
        // 设置内容的输入区域
        contentText.setBounds(120, 130, 430, 350);
        contentText.setFont(new Font("微软雅黑", Font.PLAIN, 16));
        this.getContentPane().add(contentText);

        // 4.设置保存和取消按钮
        save.setBounds(120, 520, 100, 40);
        save.setFont(new Font("宋体", Font.PLAIN, 24));
        save.addActionListener(this);
        this.getContentPane().add(save);

        cancel.setBounds(445, 520, 100, 40);
        cancel.setFont(new Font("宋体", Font.PLAIN, 24));
        cancel.addActionListener(this);
        this.getContentPane().add(cancel);
    }

    // 初始化添加日记界面
    private void initFrame() {
        // 设置界面的宽高
        this.setSize(700, 700);
        // 设置界面的标题
        this.setTitle("每日一记（添加日记）");
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
        // 获取当前被点击的组件对象
        Object obj = e.getSource();
        // 判断当前被点击的是哪个组件对象
        if (obj == save) {
            System.out.println("保存按钮被点击");
            // 如果数组的最后一个日记对象不为空，那就说明二维数组存满了
            // 保存添加的内容到本地文件
            try {
                // 创建日记存储文档的文件夹对象
                File file = new File("data");
                // 得到文件夹下所有的日记存储文档的数组
                File[] files = file.listFiles();

                // 如果文件夹下没有日记文件，说明现在写的是第一个日记
                if (files.length == 0) {
                    //序列化
                    // 与日记文档建立连接管道（特别的：第一个新文件名的序号1）
                    ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream("data\\data" + 1 + ".txt"));
                    // 将输入框的标题和内容封装成一个日记对象写到本地文件中（特别的：第一个新日记的编号1）
                    Daily daily = new Daily(1, titleText.getText(), contentText.getText());
                    // 利用糊涂包将序列化的日记对象写入到本地文件中
                    IoUtil.writeObjects(bw, true, daily);
                    // 关闭流
                    bw.close();
                }else {
                    // 将最后一个日记文件的路径转换成字符串
                    String str = files[files.length - 1] + "";
                    // 截取最后一个日记文件的序号
                    int ID = str.charAt(15) - '0';
                    // 与日记文档建立连接管道（特别的：新文件名的序号就是最后一个文件名的序号 +1）
                    ObjectOutputStream bw = new ObjectOutputStream(new FileOutputStream("data\\data" + (ID + 1) + ".txt"));
                    // 将输入框的标题和内容封装成一个日记对象写到本地文件中（特别的：新日记的编号就是最后一个日记的编号 +1）
                    Daily daily = new Daily(ID + 1, titleText.getText(), contentText.getText());
                    // 利用糊涂包将序列化的日记对象写入到本地文件中
                    IoUtil.writeObjects(bw, true, daily);
                    // 关闭流
                    bw.close();
                }
                // 关闭当前界面回到主界面
                this.setVisible(false);
                new NoteJFrame();
            } catch (IOException ex) { // 捕获异常
                throw new RuntimeException(ex);
            }

        } else if (obj == cancel) {
            System.out.println("取消按钮被点击");
            // 关闭当前界面回到主界面
            this.setVisible(false);
            new NoteJFrame();
        }
    }
}
