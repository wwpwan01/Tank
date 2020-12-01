package com.wwp.factory;

import com.wwp.tank.Dir;
import com.wwp.tank.Group;
import com.wwp.tank.TankFrame;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName GameFactory.java
 * @Description 抽象工厂
 * @createTime 2020-11-29 21:11:00
 */
public abstract class GameFactory {

    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tankFrame);

    public abstract BaseExploades createExploades(int x, int y, Dir dir, Group group, TankFrame tankFrame);

}
