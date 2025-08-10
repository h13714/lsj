package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //定义一个二维数组，用来存储图片的数字
    int[][] board = new int[4][4];
    //定义一个变量，用来记录空格的位置
    int x,y;
    //定义一个变量,用于记录当前图片所在位置
    String path = "E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\animal\\animal3\\";
    //定义一个变量,用于判断是否胜利
    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}
    };
    //定义一个变量用于统计步数
    int step = 0;
    //定义一个变量用于记录重新随机的图片
    int select = 0;

    //JMenuItem 菜单项
    JMenuItem replayItem = new JMenuItem("重新游戏");
    JMenuItem reLoginItem = new JMenuItem("重新登录");
    JMenuItem closeItem = new JMenuItem("关闭游戏");

    JMenuItem accountItem = new JMenuItem("邮箱");

    JMenuItem animalItem = new JMenuItem("动物");
    JMenuItem girlItem = new JMenuItem("女孩");
    JMenuItem sportsItem = new JMenuItem("运动");


    public GameJFrame() {
        //界面设置
        initJFrame();

        //菜单设置
        initJMenuBar();
        
        //初始化数据
        initData();

        //初始化图片
        initImage();

        //设置窗口可见
        this.setVisible(true);
    }

    //初始化数据
    private void initData() {
        //创建一个数组
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        // 打乱数组
        Random rand = new Random();
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = rand.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }

        //将数组中的数字，存储到二维数组中
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0){
                x = i / 4;
                y = i % 4;
            }
            board[i / 4][i % 4] = arr[i];
        }
    }

    //初始化图片
    private void initImage() {
        //清空界面的所有图片
        this.getContentPane().removeAll();
        //判断是否胜利
        if(victory()){
            JLabel winJLabel = new JLabel(new ImageIcon("E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\win.png"));
            winJLabel.setBounds(203,283,197,73);
            this.getContentPane().add(winJLabel);
        }

        //显示步数
        JLabel stepJLabel = new JLabel("步数: " + step);
        stepJLabel.setBounds(50,30,100,20);
        this.getContentPane().add(stepJLabel);

        //遍历数组，根据数组中的数字，显示对应的图片
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个ImageIcon对象，创建一个JLabel对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(path + board[i][j] + ".jpg"));
                //设置图片的位置和大小
                jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                //this.add(jLabel);
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\background.png"));
        background.setBounds(40,40,508,560);
        this.getContentPane().add(background);

        //刷新界面
        this.getContentPane().repaint();

    }

    //菜单设置
    private void initJMenuBar() {
        //JMenuBar 菜单条
        JMenuBar jMenuBar = new JMenuBar();

        //JMenu 菜单
        JMenu fuctionJMenu = new JMenu("功能");
        JMenu aboutJMenu = new JMenu("关于我");
        JMenu changeJMenu = new JMenu("更换图片");

        //添加菜单的监听
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);
        girlItem.addActionListener(this);
        animalItem.addActionListener(this);
        sportsItem.addActionListener(this);

        //将菜单项添加到菜单中
        changeJMenu.add(girlItem);
        changeJMenu.add(animalItem);
        changeJMenu.add(sportsItem);
        fuctionJMenu.add(replayItem);
        fuctionJMenu.add(reLoginItem);
        fuctionJMenu.add(closeItem);
        aboutJMenu.add(accountItem);


        //将菜单添加到菜单条中
        jMenuBar.add(fuctionJMenu);
        jMenuBar.add(aboutJMenu);
        fuctionJMenu.add(changeJMenu);

        this.setJMenuBar(jMenuBar);
    }

    //界面设置
    private void initJFrame() {
        this.setSize(603,680);
        this.setTitle("拼图小游戏 V1.0");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认居中放置
        this.setLayout(null);

        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == 65){
            this.getContentPane().removeAll();
            JLabel jLabel = new JLabel(new ImageIcon(path+"all.jpg"));
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);
            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\background.png"));
            background.setBounds(40,40,508,560);
            this.getContentPane().add(background);

            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()){
            return;
        }
        int code = e.getKeyCode();
        if(code == 37) {
            //System.out.println("向左移动");
            if(y < 3) {
                board[x][y] = board[x][y + 1];
                board[x][y + 1] = 0;
                y++;
                //每移动一次，步数加1
                step++;
            }else if(y == 3){
                return;
            }
            initImage();
        }
        else if(code == 38) {
            if(x < 3) {
                board[x][y] = board[x + 1][y];
                board[x + 1][y] = 0;
                x++;
                //每移动一次，步数加1
                step++;
            }else if(x == 3){
                return;
            }
            //重新初始化图片
            initImage();
        }
        else if(code == 39) {
            //System.out.println("向右移动");
            if(y > 0) {
                board[x][y] = board[x][y - 1];
                board[x][y - 1] = 0;
                y--;
                //每移动一次，步数加1
                step++;
            }else if(y == 0){
                return;
            }
            initImage();
        }
        else if(code == 40) {
            //System.out.println("向下移动");
            if(x > 0) {
                board[x][y] = board[x - 1][y];
                board[x - 1][y] = 0;
                x--;
                //每移动一次，步数加1
                step++;
            }else if(x == 0){
                return;
            }
            //重新初始化图片
            initImage();
        } else if (code == 65) {
            initImage();
        }else if(code == 87){
            board = new int[][]{
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            initImage();
        }
    }

    //判断是否胜利
    public boolean victory(){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] != win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            //重新游戏
            //计步器清零
            step = 0;
            //初始化数据
            initData();
            //初始化图片
            initImage();
        }
        else if(obj == reLoginItem){
            //重新登录
            //关闭当前游戏界面
            this.setVisible(false);
            //打开登录界面
            new LoginJFrame();
        }
        else if(obj == closeItem){
            System.exit(0);
        }
        else if(obj == accountItem){
            //邮箱
            //设置一个弹框
            JDialog jd = new JDialog();
            jd.setTitle("我的邮箱");//设置标题

            //设置一个文本框
            JTextArea jTextArea = new JTextArea();
            jTextArea.setText("3486922838@qq.com");
            jTextArea.setEditable(false);//设置文本框不可编辑
            jTextArea.setLineWrap(true);//设置文本框自动换行
            jd.add(jTextArea);//添加文本框到弹框中

            jd.setSize(250,100);//设置弹框的大小
            jd.setLocationRelativeTo(null);//弹框居中显示
            jd.setAlwaysOnTop(true);//置顶显示
            jd.setModal(true);//设置弹框不关闭则无法操作其他窗口
            jd.setVisible(true);//显示弹框
        }
        else if(obj == animalItem){
            step = 0;
            Random rand = new Random();
            select = rand.nextInt(8) + 1;
            path = "E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\animal\\animal"+select+"\\";
            initData();
            initImage();
        }
        else if(obj == girlItem){
            step = 0;
            Random rand = new Random();
            select = rand.nextInt(10) + 1;
            path = "E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\girl\\girl"+select+"\\";
            initData();
            initImage();
        }
        else if(obj == sportsItem){
            step = 0;
            Random rand = new Random();
            select = rand.nextInt(10) + 1;
            path = "E:\\Javaworksapce\\Studyfromstart\\puzzlegame\\image\\sport\\sport"+select+"\\";
            initData();
            initImage();
        }
    }
}
