package com.wwp.factory;

import com.wwp.tank.ResourceMgr;
import com.wwp.tank.TankFrame;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BaseExploades.java
 * @Description 爆炸抽象类
 * @createTime 2020-11-29 21:22:00
 */
public abstract class BaseExploades {

    public static int WIDTH = ResourceMgr.exploades[0].getWidth();
    public static int HEIGHT = ResourceMgr.exploades[0].getHeight();

    protected TankFrame tankFrame;

    public abstract void paint(Graphics g);

    protected int x,y;

    private boolean living;

    public int temp = 0;

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
}
