package com.wwp.tank;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BulletFirs.java
 * @Description 四方向子弹策略
 * @createTime 2020-11-22 19:19:00
 */
public class BulletFourDirFirs implements BulletStrategy<Tank> {

    @Override
    public void fir(Tank tank) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        for (Dir dir: Dir.values()) {
//            new Bullet(bx, by, dir, tank.getGroup(),tank.tankFrame);
        }
    }
}
