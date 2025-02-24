package ui;

import javax.swing.*;

public class RegisterFrame extends JFrame {
    //利用构造方法进行数据初始化
    public RegisterFrame(){
        //调用界面初始化方法
        initJFrame();

        this.setVisible(true);//主界面默认是隐藏的，默认参数为false
    }

    private void initJFrame() {
        //创建一个注册界面
        this.setSize(488,500);

        this.setTitle("java拼图小游戏-注册");

        this.setAlwaysOnTop(true);//设置界面置顶

        this.setLocationRelativeTo(null);//设置界面居中

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭方式

        this.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件
    }
}