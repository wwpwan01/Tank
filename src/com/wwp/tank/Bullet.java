package com.wwp.tank;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName Bullet.java
 * @Description 子弹
 * @createTime 2020-11-17 15:30:00
 */
public class Bullet extends GameObject{
    private static final int SPEED = 10;
    public static int WIDTH = ResourceMgr.bulletD.getWidth();
    public static int HEIGHT = ResourceMgr.bulletD.getHeight();

//    private int x,y;

    private Dir dir;

    private boolean living = true;

    private Group group = Group.BED;

    public Rectangle rectangle = new Rectangle();

    GameModle gm;

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Bullet(int x, int y, Dir dir, Group group, GameModle gameModle) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.gm = gameModle;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

    }
    public Bullet(){

    }
    @Override
    public void paint(Graphics g) {
        if(!living){
            gm.remove(this);
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

    @Override
    public void exploades(Exploades exploades) {

    }

    @Override
    public void returnLastDir(Dir dir) {

    }

    @Override
    public void stop() {

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
        //更新边界检测对象
        rectangle.x = this.x;
        rectangle.y = this.y;
        //存活属性
        if(x < 0 || y < 0 || y > gm.GAME_HEIGHT || x > gm.GAME_WIDTH){
            this.die();
        }
    }

    public void die() {
        this.living = false;
        gm.remove(this);
    }
}
