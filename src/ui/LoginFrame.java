package ui;

import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class LoginFrame extends JFrame implements KeyListener, ActionListener, MouseListener {
    JButton loginJbt = new JButton("登录");
    JButton registerJbt = new JButton("注册");
    //JLabel RandCodeLabel = new JLabel(getRandomStr());
    JButton RandomCodeJbt = new JButton(getRandomStr());

    //利用构造方法进行数据初始化
    public LoginFrame(){
        //调用界面初始化方法
        initJFrame();

        //加载相关组件
        initData();

        this.setVisible(true);//主界面默认是隐藏的，默认参数为false
    }

    private void initData() {
        this.getContentPane().removeAll();//清空

        getRandCode();

        JLabel userLabel = new JLabel("用户名：");
        userLabel.setBounds(120,100,60,20);
        this.getContentPane().add(userLabel);
        JTextField userText = new JTextField();
        userText.setBounds(180,100,180,20);
        this.getContentPane().add(userText);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(120,150,60,20);
        this.getContentPane().add(passwordLabel);
        JPasswordField passwordText = new JPasswordField();
        passwordText.setBounds(180,150,180,20);
        this.getContentPane().add(passwordText);

        JLabel codeLabel = new JLabel("验证码：");
        codeLabel.setBounds(120,200,60,20);
        this.getContentPane().add(codeLabel);
        JTextField codeText = new JTextField();
        codeText.setBounds(180,200,110,20);
        this.getContentPane().add(codeText);

        //添加按钮组件
        loginJbt.setBounds(260,250,70,40);
        loginJbt.addActionListener(this);

        registerJbt.setBounds(130,250,70,40);
        registerJbt.addActionListener(this);

        this.getContentPane().add(loginJbt);
        this.getContentPane().add(registerJbt);

        //背景图片
        ImageIcon backGround = new ImageIcon("GameImage/其他/背景.png");
        JLabel backGroundLabel = new JLabel(backGround);
        backGroundLabel.setBounds(0,0,723,797);
        this.getContentPane().add(backGroundLabel);
        this.getContentPane().repaint();//刷新界面

    }

    private void getRandCode() {
        RandomCodeJbt.setBounds(310, 200, 70, 20);
        RandomCodeJbt.addMouseListener(this);
        this.getContentPane().add(RandomCodeJbt);
    }

    private void initJFrame() {
        //创建一个登录界面
        this.setSize(488,430);

        this.setTitle("java拼图小游戏-登录");//设置界面名称

        this.setAlwaysOnTop(true);//设置界面置顶

        this.setLocationRelativeTo(null);//设置界面居中

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭方式

        this.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件
    }

    //生成随机验证码
    private String getRandomStr(){
        //StringBuilder StrBuilder = new StringBuilder();
        Random random = new Random();
        char[] randomChars = new char[5];
        for (int index = 0; index < randomChars.length; index++) {
            randomChars[index]=(char)(random.nextInt(10)+48);
        }
        String Str =new String(randomChars);
        //String Str=StrBuilder.toString();
        return Str;
    }


    //键盘监听
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    //动作监听
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==loginJbt){
            this.setVisible(false);
            new GameFrame();
        }else if(e.getSource()==registerJbt){
            this.setVisible(false);
            new RegisterFrame();
        }
    }

    //鼠标监听
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if(e.getSource()==RandomCodeJbt){
            //initData();
            this.getContentPane().removeAll();
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
