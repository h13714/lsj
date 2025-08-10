package test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyJFrame3 extends JFrame implements KeyListener {
    public MyJFrame3() {
        this.setSize(603,680);
        this.setTitle("事件测试界面");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.addKeyListener(this);


        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("键盘被按下了");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("键盘被松开了");
        int code = e.getKeyCode();
        if(code == 65){
            System.out.println("你按了A键");
        } else if (code == 66) {
            System.out.println("你按了B键");
        }
    }
}
