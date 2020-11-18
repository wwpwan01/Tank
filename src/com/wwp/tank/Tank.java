package com.wwp.tank;

import java.awt.*;
import java.util.Random;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName Tank.java
 * @Description 坦克类
 * @createTime 2020-11-17 14:29:00
 */
public class Tank {
    private int x, y;
    private boolean moving = true;

    private Dir dir = Dir.DOWN;

    public static int WIDTH = ResourceMgr.tankD.getWidth();
    public static int HEIGHT = ResourceMgr.tankD.getHeight();

    private TankFrame tankFrame;

    private boolean living = true;

    //区分敌我
    private Group group = Group.BED;

    //随机方向
    private Random random = new Random();

    public Tank(int x, int y, Dir dir,Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    private final int SPEED = 5;

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

    public void paint(Graphics g) {
        if(!living){
            tankFrame.tanks.remove(this);
        }
        //填充矩形
//        Color c = g.getColor();
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
//        g.setColor(c);
        switch (dir) {
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y, null);
                break;
            default:
                break;
        }
        move();

    }

    private void move() {
        if (!moving) {
            return;
        }
        switch (dir) {
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if(random.nextInt(10) > 8) {
            this.fire();
        }
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH/2 - Bullet.WIDTH/2;
        int by = this.y + Tank.HEIGHT/2 - Bullet.HEIGHT/2;
        tankFrame.bulletList.add(new Bullet(bx, by, this.dir,this.group, this.tankFrame));
    }

    public void die() {
        this.living = false;
    }
}
