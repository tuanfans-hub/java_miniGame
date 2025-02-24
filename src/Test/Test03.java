package Test;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class Test03 implements MouseListener {
    /*事件
     * 1.事件源：按钮、图片、窗体...
     * 2.事件：某些操作，如：鼠标单击，鼠标划入...
     * 3.绑定监听：当事件源上发生了某个事件，则执行某段代码
     * KeyListener:键盘监听
     * MouseListener:鼠标监听
     * ActionListener:动作监听
     * */
    JFrame jFrame = new JFrame("鼠标监听测试");
    //创建一个按钮对象
    JButton jtb = new JButton("我在这");
    public Test03() {

        jFrame.setSize(602,680);//设置主界面大小
        jFrame.setAlwaysOnTop(true);//设置界面置顶
        jFrame.setLocationRelativeTo(null);//设置界面居中
        jFrame.setDefaultCloseOperation(3);//设置默认关闭方式
        jFrame.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件



        //设置按钮位置坐标及大小
        jtb.setBounds(280,300,75,40);
        //添加鼠标监听组件
        //this调用者：苯类对象
        jtb.addMouseListener(this);
        jFrame.add(jtb);


        jFrame.setVisible(true);//主界面默认是隐藏的，默认参数为false

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("恭喜！！！鼠标点击成功！");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //设置按钮位置坐标及大小
        Random random = new Random();
        int x= random.nextInt(500);
        int y= random.nextInt(600);
        jtb.setBounds(x,y,75,40);
        //添加鼠标监听组件
        //this调用者：苯类对象
        //jtb.addMouseListener(this);
        jFrame.add(jtb);
        //System.out.println("鼠标按下不松！");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("点击失败！你行不行啊？！");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //设置按钮位置坐标及大小
        Random random = new Random();
        int x= random.nextInt(500);
        int y= random.nextInt(600);
        jtb.setBounds(x,y,75,40);
        //添加鼠标监听组件
        //this调用者：苯类对象
        //jtb.addMouseListener(this);
        jFrame.add(jtb);
        //System.out.println("鼠标指针划入！");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //System.out.println("鼠标指针划出");
    }
}
