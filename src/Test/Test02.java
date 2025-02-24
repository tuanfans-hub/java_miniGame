package Test;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test02 extends JFrame implements KeyListener{
    /*事件
        * 1.事件源：按钮、图片、窗体...
        * 2.事件：某些操作，如：鼠标单击，鼠标划入...
        * 3.绑定监听：当事件源上发生了某个事件，则执行某段代码
        * KeyListener:键盘监听
        * MouseListener:鼠标监听
        * ActionListener:动作监听
        * */
    public Test02() {
        this.setTitle("键盘监听测试");
        this.setSize(602,680);//设置主界面大小
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(3);//设置默认关闭方式
        this.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件



        //添加键盘监听组件
        //this调用者：本类对象
        this.addKeyListener(this);


        this.setVisible(true);//主界面默认是隐藏的，默认参数为false

    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    //1.如果键盘没有松开，会一直调用keyPressed方法
    //2.每个键盘按键都一个不同的编号与之对应，以区分不同的键盘按键
    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("按下不松");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        System.out.println("松开按键");
        System.out.println(keyChar+"的键盘编号为:"+keyCode);
    }
}
