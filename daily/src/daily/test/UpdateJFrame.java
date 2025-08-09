package daily.test;

import daily.entity.Daily;
import cn.hutool.core.io.IoUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

// 修改日记界面
public class UpdateJFrame extends JFrame implements ActionListener {
    // 日记的编号
    int ID;

    public UpdateJFrame(int ID) {
        this.ID = ID;
        // 初始化修改日记界面
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
    // 创建修改和取消按钮
    JButton update = new JButton("修改");
    JButton cancel = new JButton("取消");

    // 保存当前被选中的日记文档的路径
    String path;
    // 定义空日记对象
    Daily daily;

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
        update.setBounds(120, 520, 100, 40);
        update.setFont(new Font("宋体", Font.PLAIN, 24));
        update.addActionListener(this);
        this.getContentPane().add(update);

        cancel.setBounds(445, 520, 100, 40);
        cancel.setFont(new Font("宋体", Font.PLAIN, 24));
        cancel.addActionListener(this);
        this.getContentPane().add(cancel);

        // 记录该日记文档的路径
        path = "daily\\data\\data" + ID + ".txt";
        // 反序列化得到该日记文档对象
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            daily = (Daily) ois.readObject();
            ois.close();
            titleText.setText(daily.getTitle());
            contentText.setText(daily.getContent());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // 将数据显示到标题输入框、内容区域
    }

    // 初始化修改日记界面
    private void initFrame() {
        // 设置界面的宽高
        this.setSize(700, 700);
        // 设置界面的标题
        this.setTitle("每日一记（修改日记）");
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
        if (obj == update) {
            System.out.println("修改按钮被点击");
            try {
                // 保存修改后的内容到本地文件
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
                // 将输入框的内容封装成日记对象并写到本地文件中
                IoUtil.writeObjects(oos, true,
                        new Daily(daily.getID(), titleText.getText(), contentText.getText()));
                oos.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            // 关闭当前界面回到主界面
            this.setVisible(false);
            new NoteJFrame();

        } else if (obj == cancel) {
            System.out.println("取消按钮被点击");
            // 关闭当前界面回到主界面
            this.setVisible(false);
            new NoteJFrame();
        }
    }
}
