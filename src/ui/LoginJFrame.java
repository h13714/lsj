package ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import cn.hutool.core.io.FileUtil;
import util.CodeUtil;
import java.util.ArrayList;
import java.util.List;

public class LoginJFrame extends JFrame implements MouseListener {
    //创建一个集合存储正确的用户名和密码
    ArrayList<User> allUsers = new ArrayList<>();

    //添加一个path属性，用于存储图片的路径
    private final String path = "E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\login\\";
    //添加JButton属性，用于存储登录和注册按钮
    private final JButton login = new JButton();
    private final JButton register = new JButton();

    //生成一个验证码JLabel储存生成的验证码
    JLabel rightCode = new JLabel();

    //添加输入框
    JTextField username = new JTextField();
    JTextField password = new JTextField();
    JTextField code = new JTextField();


    public LoginJFrame() {
        //读取文件
        readUserInfo();

        //初始化界面
        initJFrame();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    private void readUserInfo() {
        List<String> userInfoStrList = FileUtil.readUtf8Lines("E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\userinfo.txt");
        for (String str : userInfoStrList) {
            String[] userInfoList = str.split("&");
            String arr1 = userInfoList[0].split("=")[1];
            String arr2 = userInfoList[1].split("=")[1];
            allUsers.add(new User(arr1, arr2));
        }
        System.out.println(allUsers);
    }

    //添加组件
    public void initView() {
        //1. 添加用户名文字
        JLabel usernameText = new JLabel(new ImageIcon(path + "用户名.png"));
        usernameText.setBounds(116, 135, 47, 17);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(195, 134, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel(new ImageIcon(path + "\\密码.png"));
        passwordText.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(195, 195, 200, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel(new ImageIcon(path + "验证码.png"));
        codeText.setBounds(133, 256, 50, 30);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(195, 256, 100, 30);
        this.getContentPane().add(code);

        //生成验证码
        String codeStr = CodeUtil.getCode();

        //设置内容
        rightCode.setText(codeStr);
        //位置和宽高
        rightCode.setBounds(300, 256, 50, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon(path + "登录按钮.png"));
        //去除按钮的默认边框
        login.setBorderPainted(false);
        //去除按钮的默认背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon(path + "注册按钮.png"));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon(path + "background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);

        //8.添加鼠标监听
        login.addMouseListener(this);//给登录按钮添加鼠标监听
        register.addMouseListener(this);//给注册按钮添加鼠标监听
        rightCode.addMouseListener(this);//给验证码添加鼠标监听

        //可见
        this.setVisible(true);

        //刷新界面
        this.getContentPane().repaint();




    }

    //初始化界面
    public void initJFrame() {
        this.setSize(488, 430);//设置宽高
        this.setTitle("拼图游戏 V1.0登录");//设置标题
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);//设置关闭模式
        this.setLocationRelativeTo(null);//居中
        this.setAlwaysOnTop(true);//置顶
        this.setLayout(null);//取消内部默认布局
    }


    //要展示用户名或密码错误
    public void showJDialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    //点击
    @Override
    public void mouseClicked(MouseEvent e) {
        Object obj = e.getSource();
        if (obj == login) {
            //获取用户名·密码·验证码输入框中的数据
            String usernameInput = username.getText();
            String passwordInput = password.getText();
            String codeInput = code.getText();

            //创建一个User对象
            User user = new User(usernameInput, passwordInput);

            //对输入情况进行判断
            if (usernameInput.isEmpty() || passwordInput.isEmpty() || codeInput.isEmpty()) {//又一项输入为空
                showJDialog("输入不能为空");
            } else if (!codeInput.equalsIgnoreCase(rightCode.getText())) {//验证码错误
                showJDialog("验证码错误");
            } else if (contains(user)) {
                showJDialog("登录成功");
                //关闭当前界面
                this.setVisible(false);
                //打开游戏界面
                new GameJFrame();
            } else {
                showJDialog("用户名或密码错误");
            }
        }else if(obj == register){
            System.out.println("点击了注册按钮");
            //关闭当前界面
            this.setVisible(false);
            //打开注册界面
            new RegisterJFrame(allUsers);
        }else if(obj == rightCode){//点击验证码
            //重新生成一个验证码
            String code = CodeUtil.getCode();
            rightCode.setText(code);
        }
    }

    //按下不松
    @Override
    public void mousePressed(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == login){
            login.setIcon(new ImageIcon(path + "登录按下.png"));
        }else if(obj == register){
            register.setIcon(new ImageIcon(path + "注册按下.png"));
        }
    }

    //松开
    @Override
    public void mouseReleased(MouseEvent e) {
        Object obj = e.getSource();
        if(obj == login){
            login.setIcon(new ImageIcon(path + "登录按钮.png"));
        }else if(obj == register){
            register.setIcon(new ImageIcon(path + "注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        Object obj = e.getSource();

    }

    public boolean contains(User user) {
        for(User rightUser : allUsers){
            if(user.getName().equals(rightUser.getName()) && user.getPassword().equals(rightUser.getPassword())){
                return true;
            }
        }
        return false;
    }
}
