package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;
import java.util.Random;

public class GameFrame extends JFrame implements KeyListener, ActionListener{
    //创建项目选项（功能：重新游戏、重新登入、关闭游戏  关于我们：公众号）
    JMenuItem replayItem=new JMenuItem("重新游戏");

    JMenuItem reLoginItem=new JMenuItem("重新登录");

    JMenu changeImage=new JMenu("切换图片");
    JMenuItem jin=new JMenuItem("金瓶儿");
    JMenuItem Lu=new JMenuItem("陆雪琪");

    JMenuItem closeItem=new JMenuItem("关闭游戏");

    JMenuItem accountItem=new JMenuItem("公众号");

    int baiIndex=0;//记录空白索引
    int count=0;//统计游戏步数
    int[] Number= {0,1,2,3,4,5,6,7,8};
    int[] passNumber={0,1,2,3,4,5,6,7,8};
    String[] paths = {"GameImage/金瓶儿/","GameImage/陆雪琪/"};
    Random random = new Random();
    int imageIndex=random.nextInt(2);

    //利用构造方法进行数据初始化
    public GameFrame(){
        //调用初始化界面方法
        initJFrame();

        //调用初始化菜单方法
        initJMenuBar();

        //调用初始化图片方法
        Number=initData();
        initImage(Number);

        //调用图片移动方法
        startGame();

        this.setVisible(true);//主界面默认是隐藏的，默认参数为false
    }

    //进行游戏
    private void startGame() {

        this.addKeyListener(this);

    }

    //打乱图片，为初始化图片做准备
    private int[] initData() {
        Random random = new Random();
        for(int k=0;k<Number.length;k++){
            int index=random.nextInt(Number.length);
            int temp = Number[index];
            Number[index] = Number[k];
            Number[k]=temp;
        }
        return Number;
    }

    //初始化图片
    private void initImage(int[] Number) {
        this.getContentPane().removeAll();//清空图片
        //判断游戏是否胜利，胜利则显示胜利图标
        if(passGame()){
            JLabel passLabel = new JLabel(new ImageIcon("GameImage/其他/胜利图标.png"));
            passLabel.setBounds(70,200,577,266);
            this.getContentPane().add(passLabel);
        }
        //记录游戏步数
        JLabel countLabel = new JLabel("游戏步数："+count);
        countLabel.setBounds(580,50,100,20);
        this.getContentPane().add(countLabel);

        //加载游戏图片
        int index=0;
        for(int j=0;j<3;j++){
            for(int i=0;i<3;i++){
                int number;
                number=Number[index++]+1;
                if(number==9){
                    baiIndex=index-1;
                }
                //创建一个图片ImageIcon的对象：ImageIcon icon = new ImageIcon("GameImage/金瓶儿/1.png");
                //创建一个JLabel的对象（管理容器）
                JLabel jLabel = new JLabel(new ImageIcon(paths[imageIndex]+number+".png"));
                //指定图片位置
                jLabel.setBounds(200*i+45,200*j+80,200,200);
                //给图片添加边框
                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
                //把管理容器添加到界面中
                this.getContentPane().add(jLabel);
            }
        }

        //添加背景图片，图片加载规则：先添加的图片在上方，后加载的图片在下方
        addBackground();
        this.getContentPane().repaint();//刷新界面
    }

    //添加背景图片
    private void addBackground() {
        //添加背景图片
        ImageIcon bg=new ImageIcon("GameImage/其他/背景.png");
        //创建一个JLabel的对象（管理容器）
        JLabel background = new JLabel(bg);
        //指定图片位置
        background.setBounds(0,0,bg.getIconWidth(),bg.getIconHeight());
        //把管理容器添加到界面中
        this.getContentPane().add(background);
    }

    //初始化菜单
    private void initJMenuBar() {
        //创建游戏菜单
        JMenuBar jMenuBar = new JMenuBar();

        //创建菜单项目（功能 关于我们）
        JMenu functionMenu=new JMenu("功能");
        JMenu aboutMenu=new JMenu("关于我们");


        //将选项放入对应的项目中
        functionMenu.add(replayItem);
        functionMenu.add(reLoginItem);
        functionMenu.add(changeImage);
        changeImage.add(jin);
        changeImage.add(Lu);
        functionMenu.add(closeItem);
        aboutMenu.add(accountItem);

        //给选项绑定事件
        replayItem.addActionListener(this);
        reLoginItem.addActionListener(this);
        changeImage.addActionListener(this);
        jin.addActionListener(this);
        Lu.addActionListener(this);
        closeItem.addActionListener(this);
        accountItem.addActionListener(this);

        //将项目放入菜单中
        jMenuBar.add(functionMenu);
        jMenuBar.add(aboutMenu);

        //给游戏界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    //初始化界面
    private void initJFrame() {
        //创建一个游戏的主界面
        this.setSize(702,780);//设置主界面大小
        this.setTitle("java拼图小游戏 V1.0");
        this.setAlwaysOnTop(true);//设置界面置顶
        this.setLocationRelativeTo(null);//设置界面居中
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//设置默认关闭方式
        this.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件
    }

    //显示完整图片
    private void appearImage(){
        this.getContentPane().removeAll();
        JLabel allImage = new JLabel(new ImageIcon(paths[imageIndex]+"10.png"));
        allImage.setBounds(45,80,600,600);
        this.getContentPane().add(allImage);
        addBackground();
        this.getContentPane().repaint();
    }

    //判断游戏是否胜利
    private boolean passGame(){
        return Arrays.equals(Number, passNumber);
    }

    //打乱图片重新加载
    private void newGame() {
        count = 0;//游戏步数清零
        initData();//重新打乱图片位置
        initImage(Number);//重新加载图片
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(passGame()){
            return;
        }
        if(e.getKeyCode()==65){
            appearImage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //游戏胜利将无法进行键盘操作
        if(passGame()){
            return;
        }
        int[] move={-1,1,-3,3};
        int index=0;
        boolean flag=false;
        if(e.getKeyCode()==38){
            if(baiIndex!=6&&baiIndex!=7&&baiIndex!=8){
                index=baiIndex+move[3];
                flag=true;
                System.out.println("向上移动成功！");
                count++;
            }
        }else if(e.getKeyCode()==40){
            if(baiIndex!=0&&baiIndex!=1&&baiIndex!=2){
                index=baiIndex+move[2];
                flag=true;
                System.out.println("向下移动成功！");
                count++;
            }
        }else if(e.getKeyCode()==37){
            if((baiIndex>=0&&baiIndex<2)||(baiIndex>=3&&baiIndex<5)||(baiIndex>=6&&baiIndex<8)){
                index=baiIndex+move[1];
                flag=true;
                System.out.println("向左移动成功！");
                count++;
            }
        }else if(e.getKeyCode()==39){
            if((baiIndex>0&&baiIndex<=2)||(baiIndex>3&&baiIndex<=5)||(baiIndex>6&&baiIndex<=8)){
                index=baiIndex+move[0];
                flag=true;
                System.out.println("向右移动成功！");
                count++;
            }
        }else if(e.getKeyCode()==65){
            initImage(Number);//A
        }else if(e.getKeyCode()==87){
            Number=new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
            initImage(Number);
        }
        if(index>=0&&index<=8&&flag){
            int temp=Number[index];
            Number[index]=Number[baiIndex];
            Number[baiIndex]=temp;
            initImage(Number);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object item = e.getSource();
        if (item == replayItem) {
            newGame();
            System.out.println("重新游戏");
        } else if (item == jin) {
            imageIndex = 0;
            newGame();
            System.out.println("切换图片");
        }else if(item==Lu){
            imageIndex = 1;
            newGame();
            System.out.println("切换图片");
        }else if(item==closeItem){
            System.exit(0);//关闭游戏
        }else if(item==accountItem){
            //创建一个弹窗
            JDialog jDialog= new JDialog();

            //创建容器对象
            JLabel jLabel = new JLabel("没有公众号！");
            jLabel.setBounds(50,25,100,20);
            jDialog.getContentPane().add(jLabel);
            System.out.println("公众号");

            jDialog.setSize(200,120);
            jDialog.setAlwaysOnTop(true);//弹窗置顶
            jDialog.setLocationRelativeTo(null);//弹窗居中
            jDialog.setModal(true);//弹窗不关闭无法进行游戏操作
            jDialog.setLayout(null);//取消默认的居中放置，只有取消之后才能按照XY轴的形式调价组件
            jDialog.setVisible(true);//显示弹窗
        }else if(item==reLoginItem){
            this.setVisible(false);
            new LoginFrame();
            System.out.println("重新登录");
        }
    }

}
