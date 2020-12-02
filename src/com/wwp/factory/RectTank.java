package com.wwp.factory;

import com.wwp.tank.*;

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
public class RectTank extends BaseTank {

//    BulletStrategy bulletFirs;

//    private Exploades exploades;

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
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

//        if(group == Group.GOOD){
//            String goodBullet = PropertyMsg.get("goodBullet");
//            try {
//                bulletFirs = (BulletStrategy) Class.forName(goodBullet).newInstance();
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            }
//        }else {
//            bulletFirs = new BulletOneDirFirs();
//        }
    }

    private final int SPEED = 5;


    @Override
    public void paint(Graphics g) {
        if (!living) {
            tankFrame.tanks.remove(this);
        }
        Color c = g.getColor();
        // 填充矩形
        g.setColor(Color.BLUE);
        if(group == Group.GOOD){
            g.setColor(Color.RED);
        }
        g.fillRect(x, y, WIDTH, HEIGHT);
        g.setColor(c);
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
}
