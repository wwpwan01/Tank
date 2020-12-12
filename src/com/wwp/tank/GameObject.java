package com.wwp.tank;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName GameObject.java
 * @Description TODO
 * @createTime 2020-12-09 21:49:00
 */
public abstract class GameObject {
    int x,y;
    public abstract void paint(Graphics g);

    public abstract void exploades(Exploades exploades);

    public abstract void returnLastDir(Dir dir);

    public abstract void stop();
}
