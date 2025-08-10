package ui;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        //创建一个主界面
        JFrame gameJFrame = new JFrame();
        gameJFrame.setSize(603,680);
        gameJFrame.setVisible(true);

        //登录界面
        JFrame loginJFrame = new JFrame();
        loginJFrame.setSize(488,430);
        loginJFrame.setVisible(true);

        //注册界面
        JFrame registerJFrame = new JFrame();
        registerJFrame.setSize(488,500);
        registerJFrame.setVisible(true);
    }
}
