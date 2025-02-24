package Test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test01 {
/*事件
* 1.事件源：按钮、图片、窗体...
* 2.事件：某些操作，如：鼠标单击，鼠标划入...
* 3.绑定监听：当事件源上发生了某个事件，则执行某段代码
* KeyListener:键盘监听
* MouseListener:鼠标监听
* ActionListener:动作监听
* */
    public Test01() {
        JFrame jFrame = new JFrame("动作监听测试");
        jFrame.setSize(602,680);//设置主界面大小
        jFrame.setAlwaysOnTop(true);//设置界面置顶
        jFrame.setLocationRelativeTo(null);//设置界面居中
        jFrame.setDefaultCloseOperation(3);//设置默认关闭方式
        jFrame.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件


        //创建一个按钮对象
        JButton jtb = new JButton("点我！");
        //设置按钮位置坐标及大小
        jtb.setBounds(280,300,100,62);
        //添加按钮监听组件
        //jtb.addActionListener(new MyActionListener());

        //当一个接口的实现类只被一个对象调用时，可以适应匿名内部类
        jtb.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("按钮已点击！");
            }
        });
        jFrame.add(jtb);


        jFrame.setVisible(true);//主界面默认是隐藏的，默认参数为false


    }
}
