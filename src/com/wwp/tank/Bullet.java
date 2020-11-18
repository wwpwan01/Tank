package com.wwp.tank;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName Bullet.java
 * @Description TODO
 * @createTime 2020-11-17 15:30:00
 */
public class Bullet {
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();
    private int x,y;
    private Dir dir;

    private TankFrame tankFrame;

    private boolean living = true;

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Bullet(int x, int y, Dir dir, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tankFrame = tankFrame;
    }
    public Bullet(){

    }
    public void paint(Graphics g) {
        if(!living){
            tankFrame.bulletList.remove(this);
        }
//        Color c = g.getColor();
//        g.setColor(Color.RED);
//        //填充矩形
//        g.fillOval(x, y, TANK_WIDTH, TANK_HEIGHT);
//        g.setColor(c);
        switch (dir) {
            case DOWN:
                g.drawImage(ResourceMgr.bulletD, x, y, null);
                break;
            case UP:
                g.drawImage(ResourceMgr.bulletU, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR, x, y, null);
                break;
            default:
                break;
        }
        move();

    }
    private void move() {
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
        if(x < 0 || y < 0 || y > tankFrame.GAME_HEIGHT || x > tankFrame.GAME_WIDTH){
            this.living = false;
        }
    }

    public void collidWith(Tank tank) {
        Rectangle rectangle = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rectangle1 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rectangle.intersects(rectangle1)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
