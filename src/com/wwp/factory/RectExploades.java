package com.wwp.factory;

import com.wwp.tank.ResourceMgr;
import com.wwp.tank.TankFrame;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName RectExploades.java
 * @Description 方块爆炸实现
 * @createTime 2020-11-29 21:37:00
 */
public class RectExploades extends BaseExploades {

    public RectExploades(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }
    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x,y,10*temp,10*temp);
        temp++;
        g.setColor(color);
        if(temp>9){
            tankFrame.exploades.remove(this);
        }
        System.out.println("die");
    }
}
