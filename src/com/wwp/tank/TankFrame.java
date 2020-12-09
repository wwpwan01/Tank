package com.wwp.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wwp
 * @version 1.0.0
 * @ClassName TankFrame.java
 * @Description 主战区域
 * @createTime 2020-11-10 20:35:00
 */
public class TankFrame extends Frame {

    GameModle gameModle = new GameModle();

//    Bullet b = new Bullet(200, 200, Dir.DOWN,this);



    public TankFrame() {
        //窗口
        //窗口大小
        setSize(gameModle.GAME_WIDTH, gameModle.GAME_HEIGHT);
        //是否可以改版大小
        setResizable(false);
        //窗口标题
        setTitle("tank war");
        //设置可见
        setVisible(true);
        //窗口按键事件
        addKeyListener(new MyKeyListener());
        //window监听器 点x号可以关闭窗口
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    /**
     * @author wwp
     * @description 解决屏幕闪烁
     * @Params Graphics
     * @updateTime 2020/11/17 15:43
     * @throws
     * @return
     */

    Image ima = null;

    @Override
    public void update(Graphics g) {
        if (ima == null) {
            ima = this.createImage(gameModle.GAME_WIDTH, gameModle.GAME_WIDTH);
        }
        Graphics graphics = ima.getGraphics();
        Color c = graphics.getColor();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0, 0, gameModle.GAME_WIDTH, gameModle.GAME_HEIGHT);
        graphics.setColor(c);
        paint(graphics);
        g.drawImage(ima, 0, 0, null);
    }

    /**
     * @throws
     * @title
     * @description 窗口中增加图形
     * @author admin
     * @updateTime 2020/11/10 20:41
     */
    @Override
    public void paint(Graphics g) {
        gameModle.paint(g);


        /*
          迭代器删除元素会报错，每次会校验元素问题，不允许其他地方删除，可以在自己的迭代器内部删除
          迭代器有个内部同步状态，两个线程同时工作，一个负责迭代修改，另一个只迭代同步的时候就会报错
          直接用for循环可以
         */
//        for (Bullet bullet : bulletList){
//            bullet.paint(g);
//        }
//        for (Iterator<Bullet> iterator = bulletList.iterator(); iterator.hasNext();){
//            Bullet next = iterator.next();
//            if(!next.isLive()){
//                iterator.remove();
//            }
//        }
    }


    class MyKeyListener extends KeyAdapter {
        boolean BU = false, BD = false, BL = false, BR = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            System.out.println(keyCode);
            //获取方向键的code给方向复制，判断是否需要移动
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    BL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = true;
                    break;
                case KeyEvent.VK_UP:
                    BU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = true;
                    break;
                case KeyEvent.VK_CONTROL:
                    gameModle.getMainTank().fire();
                    break;
                default:
                    break;

            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            Tank mainTank = gameModle.getMainTank();
            if (!BL && !BR && !BU && !BD) {
                mainTank.setMoving(false);
            } else {
                mainTank.setMoving(true);
                if (BL) {
                   mainTank.setDir(Dir.LEFT);
                }
                if (BR) {
                   mainTank.setDir(Dir.RIGHT);
                }
                if (BU) {
                   mainTank.setDir(Dir.UP);
                }
                if (BD) {
                   mainTank.setDir(Dir.DOWN);
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("======");
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_LEFT:
                    BL = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    BR = false;
                    break;
                case KeyEvent.VK_UP:
                    BU = false;
                    break;
                case KeyEvent.VK_DOWN:
                    BD = false;
                    break;
                default:
                    break;

            }
            setMainTankDir();
        }
    }

}
