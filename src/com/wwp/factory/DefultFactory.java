package com.wwp.factory;

import com.wwp.tank.*;
import com.wwp.tank.Bullet;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName DefultFactory.java
 * @Description 默认风格工厂
 * @createTime 2020-11-29 21:18:00
 */
public class DefultFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Tank(x, y, dir, group, tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Bullet(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExploades createExploades(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new Exploades(x,y,tankFrame);
    }
}
