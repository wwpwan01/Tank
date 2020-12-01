package com.wwp.tank;

import com.wwp.factory.BaseTank;

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
public class Tank extends BaseTank {
    private int x, y;
    private boolean moving = true;

    private Dir dir = Dir.DOWN;

    public static int WIDTH = ResourceMgr.goodTankU.getWidth();
    public static int HEIGHT = ResourceMgr.goodTankU.getHeight();

    TankFrame tankFrame;

    private boolean living = true;

    Rectangle rectangle = new Rectangle();

    /**
     * 区分敌我
     */
    private Group group = Group.BED;

    /**
     * 随机方向
     */
    private Random random = new Random();

    BulletStrategy bulletFirs;

//    private Exploades exploades;

    public Tank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        super();
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        //我方坦克不动
        if (group == Group.GOOD) {
            moving = false;
        }

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        if(group == Group.GOOD){
            String goodBullet = PropertyMsg.get("goodBullet");
            try {
                bulletFirs = (BulletStrategy) Class.forName(goodBullet).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }else {
            bulletFirs = new BulletOneDirFirs();
        }
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

    @Override
    public void paint(Graphics g) {
        if (!living) {
            tankFrame.tanks.remove(this);
//            exploades.paint(g);
        }
        //填充矩形
//        if(){
//
//        }
//        Color c = g.getColor();
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, TANK_WIDTH, TANK_HEIGHT);
//        g.setColor(c);
        switch (dir) {
            case DOWN:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case UP:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankL: ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group == Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
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

        //坦克边界
//        BulletFourDirFirs bulletFirs;

        if (random.nextInt(100) > 95 && group != Group.GOOD) {
//            bulletFirs = new BulletOneDirFirs();
//            bulletFirs.fir(this);
            this.fire();
            this.randomDir();
        }
        //坦克边界 停止 需要改为返回继续随机
        returnTank();
        //更新边界检测对象
        rectangle.x = this.x;
        rectangle.y = this.y;
    }

    private void returnTank() {
        if (x <= 0) {
            x += SPEED;
        }
        if (x >= tankFrame.GAME_WIDTH - WIDTH) {
            x -= SPEED;
        }
        if (y <= 10) {
            y += SPEED;
        }
        if (y >= tankFrame.GAME_HEIGHT - HEIGHT) {
            y -= SPEED;
        }
    }

    /**
     * @return
     * @throws
     * @author wwp
     * @description 随机移动
     * @Params
     * @updateTime 2020/11/18 19:46
     */
    private void randomDir() {
        int i = random.nextInt(Dir.values().length);
        dir = Dir.values()[i];
    }

    public void fire() {
//        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
//        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
//        tankFrame.bulletList.add(new Bullet(bx, by, this.dir, this.group, this.tankFrame));
        bulletFirs.fir(this);
    }

    public void die() {
        this.living = false;
    }
}
