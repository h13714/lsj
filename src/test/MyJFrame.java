package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {

    JButton jb1 = new JButton("大小按钮");
    JButton jb2 = new JButton("位置按钮");

    public MyJFrame() {
        this.setSize(603,680);
        this.setTitle("事件测试界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消默认居中放置
        this.setLayout(null);

        //设置按钮的大小和位置
        jb1.setBounds(100,100,100,50);
        jb2.setBounds(200,300,100,50);

        jb1.addActionListener(this);
        jb2.addActionListener(this);

        //将按钮添加到界面中
        this.getContentPane().add(jb1);
        this.getContentPane().add(jb2);


        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Random rand = new Random();
        Object sourse = e.getSource();
        if(sourse == jb1) {
            jb1.setSize(200,100);
        } else if (sourse == jb2) {
            jb2.setLocation(rand.nextInt(500),rand.nextInt(500));
        }
    }
}
