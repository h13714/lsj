package test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class test2 extends JFrame{
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(603,680);
        frame.setTitle("事件测试界面");
        frame.setAlwaysOnTop(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(null);

        JButton jtb = new JButton();
        jtb.setBounds(100,100,100,100);
        jtb.setText("按钮");
        jtb.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮被点击了");
            }
        });

        frame.getContentPane().add(jtb);

        frame.setVisible(true);
        //取消默认居中放置
        frame.setLayout(null);
    }
}
