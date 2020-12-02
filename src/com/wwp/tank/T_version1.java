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

       TankFrame tankFrame = new TankFrame();

        Integer initTankNum = Integer.valueOf(PropertyMsg.get("initTankNum"));

        //初始化敌方坦克
        for (int i = 0; i < initTankNum; i++){
//            tankFrame.tanks.add(new Tank(50+i*80,200,Dir.LEFT,Group.BED,tankFrame));
            tankFrame.tanks.add(tankFrame.gameFactory.createTank(50+i*80,200,Dir.LEFT,Group.BED,tankFrame));
        }

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
