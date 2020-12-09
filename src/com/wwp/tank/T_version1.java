package com.wwp.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author wwp
 * @version 1.0.0
 * @ClassName T.java
 * @Description 测试区
 * @createTime 2020-11-10 20:23:00
 */
public class T_version1 {
    /**
     * @title
     * @description 开始运行给定固定窗口，并且可以关闭
     * @author admin
     * @updateTime 2020/11/10 20:30
     * @throws
     */
    public static void main(String[] args) {
       /* //窗口
        Frame f = new Frame();
        //窗口大小
        f.setSize(800,600);
        //是否可以改版大小
        f.setResizable(false);
        //窗口标题
        f.setTitle("tank war");
        //设置可见
        f.setVisible(true);
        //window监听器 点x号可以关闭窗口
        f.addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });*/

       TankFrame tankFrame = new TankFrame();

       //主线程每隔一定时间刷新窗口
       while (true){
           try {
               Thread.sleep(50);
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
           tankFrame.repaint();
       }

    }
}
