package com.wwp.tank;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName Exploades.java
 * @Description 爆炸效果
 * @createTime 2020-11-18 17:00:00
 */
public class Exploades extends GameObject{
    public static int WIDTH = ResourceMgr.exploades[0].getWidth();
    public static int HEIGHT = ResourceMgr.exploades[0].getHeight();

//    private int x,y;

    private boolean living;

    GameModle gm;

    private int temp = 0;
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Exploades(int x, int y, GameModle gameModle) {
        this.x = x;
        this.y = y;
        this.gm = gameModle;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploades[temp++],x,y,null);
        if(temp>=ResourceMgr.exploades.length){
            gm.gameObjectArrayList.remove(this);
        }
        System.out.println("die");
    }

    @Override
    public void exploades(Exploades exploades) {}

    @Override
    public void returnLastDir(Dir dir) {

    }

    @Override
    public void stop() {

    }
}
