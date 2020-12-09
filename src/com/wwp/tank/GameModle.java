package com.wwp.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName GameModle.java
 * @Description TODO
 * @createTime 2020-12-09 21:03:00
 */
public class GameModle {

    Tank tank = new Tank(200, 400, Dir.DOWN, Group.GOOD,this);

    List<Bullet> bulletList = new ArrayList<Bullet>();

    List<Tank> tanks = new ArrayList<Tank>();

    List<Exploades> exploades = new ArrayList<>();

    int GAME_WIDTH = 1600, GAME_HEIGHT = 900;

    public GameModle(){

        Integer initTankNum = Integer.valueOf(PropertyMsg.get("initTankNum"));

        //初始化敌方坦克
        for (int i = 0; i < initTankNum; i++){
            this.tanks.add(new Tank(50+i*80,200,Dir.LEFT,Group.BED,this));
        }
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.WHITE);
        g.drawString(String.valueOf(bulletList.size()), 10, 60);
        g.drawString(String.valueOf(tanks.size()), 10, 80);
        g.setColor(color);

        tank.paint(g);

        for (int i = 0; i < bulletList.size(); i++) {
            bulletList.get(i).paint(g);
        }

        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        //马老师写的爆炸效果
        for (int i = 0; i < exploades.size(); i++) {
            exploades.get(i).paint(g);
        }

        //碰撞检测  循环每个子弹合坦克
        for (int i = 0; i < bulletList.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bulletList.get(i).collidWith(tanks.get(j));
            }
        }
    }

    public Tank getMainTank() {
        return tank;
    }
}
