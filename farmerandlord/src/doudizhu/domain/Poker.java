package doudizhu.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Poker extends JLabel implements MouseListener {

    //自己练习

    private String name;
    private boolean up;
    private boolean canClick = false;
    private boolean clicked = false ;

    public Poker(String name, boolean up){
        this.name = name;
        this.up = up;
        //判断牌的正反
        if(this.up){
            turnFront();
        }else{
            turnRear();
        }

        //设置牌的宽高大小
        this.setSize(71, 96);
        //把牌显示出来
        this.setVisible(true);

        //添加鼠标监听事件
        this.addMouseListener(this);

    }

    //显示正面
    public void turnFront(){
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\" + name + ".png"));
        this.up = true;
    }

    //显示反面
    public void turnRear(){
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\rear.png"));
        this.up = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int step = 0;
        if (canClick) {
            if (clicked) {
                step = 20;
            } else {
                step = -20;
            }
        }

        Point from = this.getLocation();
        Point to = new Point(from.x, from.y + step);
        this.setLocation(to);
    }


    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public boolean isCanClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
