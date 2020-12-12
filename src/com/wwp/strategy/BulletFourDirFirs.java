package com.wwp.strategy;

import com.wwp.tank.*;

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
    public void fir(Tank tank, GameModle tankFrame) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.gameObjectArrayList.add(new Bullet(bx, by, Dir.UP, tank.getGroup(), tankFrame));
        tankFrame.gameObjectArrayList.add(new Bullet(bx, by, Dir.DOWN, tank.getGroup(), tankFrame));
        tankFrame.gameObjectArrayList.add(new Bullet(bx, by, Dir.LEFT, tank.getGroup(), tankFrame));
        tankFrame.gameObjectArrayList.add(new Bullet(bx, by, Dir.RIGHT, tank.getGroup(), tankFrame));
    }
}
