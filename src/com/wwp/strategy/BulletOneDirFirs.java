package com.wwp.strategy;

import com.wwp.tank.Bullet;
import com.wwp.tank.GameModle;
import com.wwp.tank.Tank;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BulletOneDirFirs.java
 * @Description 单一方向子弹策略
 * @createTime 2020-11-22 20:15:00
 */
public class BulletOneDirFirs implements BulletStrategy<Tank> {
    @Override
    public void fir(Tank tank, GameModle tankFrame) {
        int bx = tank.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = tank.getY() + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tankFrame.gameObjectArrayList.add(new Bullet(bx, by, tank.getDir(), tank.getGroup(), tankFrame));
    }
}
