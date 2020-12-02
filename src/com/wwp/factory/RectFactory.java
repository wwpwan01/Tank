package com.wwp.factory;

import com.wwp.tank.Dir;
import com.wwp.tank.Group;
import com.wwp.tank.TankFrame;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName RectExploadFactory.java
 * @Description 方形的具体工厂
 * @createTime 2020-11-29 21:39:00
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectTank(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectBullet(x,y,dir,group,tankFrame);
    }

    @Override
    public BaseExploades createExploades(int x, int y, Dir dir, Group group, TankFrame tankFrame) {
        return new RectExploades(x,y,tankFrame);
    }
}
