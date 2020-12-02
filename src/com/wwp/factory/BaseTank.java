package com.wwp.factory;

import com.wwp.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BaseTank.java
 * @Description 坦克抽象类
 * @createTime 2020-11-29 21:21:00
 */
public abstract class BaseTank {

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    protected TankFrame tankFrame;

    public Rectangle rectangle = new Rectangle();

    protected int x, y;
    protected boolean moving = true;

    protected Dir dir = Dir.DOWN;

    protected boolean living = true;

    /**
     * 区分敌我
     */
    protected Group group = Group.BED;

    /**
     * 随机方向
     */
    protected Random random = new Random();

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public abstract void paint(Graphics g);

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
//        tankFrame.bulletList.add(tankFrame.gameFactory.createBullet(bx,by,this.dir,group,tankFrame));
        tankFrame.gameFactory.createBullet(bx,by,this.dir,group,tankFrame);
//        tankFrame.bulletList.add(new Bullet(bx, by, this.dir, this.group, this.tankFrame));
//        bulletFirs.fir(this);
    }

    public void die() {
        this.living = false;
    }
}
