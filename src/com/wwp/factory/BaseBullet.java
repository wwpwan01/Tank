package com.wwp.factory;

import com.wwp.tank.ResourceMgr;
import com.wwp.tank.Tank;
import com.wwp.tank.TankFrame;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BaseBullet.java
 * @Description 子弹抽象类
 * @createTime 2020-11-29 21:21:00
 */
public abstract class BaseBullet {

    public static int WIDTH = ResourceMgr.bulletU.getWidth();
    public static int HEIGHT = ResourceMgr.bulletU.getHeight();

    protected TankFrame tankFrame;

    public abstract void paint(Graphics g);

    public abstract void collidWith(BaseTank tank);
}
