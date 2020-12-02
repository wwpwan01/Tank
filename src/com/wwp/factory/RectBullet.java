package com.wwp.factory;

import com.wwp.tank.*;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName Bullet.java
 * @Description 子弹
 * @createTime 2020-11-17 15:30:00
 */
public class RectBullet extends BaseBullet {
    private static final int SPEED = 10;

    private int x,y;
    private Dir dir;

    private boolean living = true;

    private Group group = Group.BED;

    Rectangle rectangle = new Rectangle();

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

    public RectBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
        this.tankFrame = tankFrame;

        rectangle.x = this.x;
        rectangle.y = this.y;
        rectangle.width = WIDTH;
        rectangle.height = HEIGHT;

        tankFrame.bulletList.add(this);
    }
    public RectBullet(){

    }
    @Override
    public void paint(Graphics g) {
        if(!living){
            tankFrame.bulletList.remove(this);
        }
        Color c = g.getColor();
        g.setColor(Color.YELLOW);
        //填充矩形
        g.fillRect(x, y, 10, 10);
        g.setColor(c);

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
        //更新边界检测对象
        rectangle.x = this.x;
        rectangle.y = this.y;
        //存活属性
        if(x < 0 || y < 0 || y > tankFrame.GAME_HEIGHT || x > tankFrame.GAME_WIDTH){
            this.die();
        }
    }

    @Override
    public void collidWith(BaseTank tank) {
        //区分敌我，不伤害队友
        if(tank.getGroup() == this.group){
            return;
        }
        if (rectangle.intersects(tank.rectangle)){
            tank.die();
            this.die();
            int ex = tank.getX() + Tank.WIDTH/2 - Exploades.WIDTH/2;
            int ey = tank.getY() + Tank.HEIGHT/2 - Exploades.HEIGHT/2;
//            tankFrame.exploades.add(new Exploades(ex,ey,tankFrame));
            tankFrame.exploades.add(tankFrame.gameFactory.createExploades(ex,ey,dir,group,tankFrame));
        }
    }

    private void die() {
        this.living = false;
    }
}
