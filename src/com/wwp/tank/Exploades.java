package com.wwp.tank;

import com.wwp.factory.BaseExploades;

import java.awt.*;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName Exploades.java
 * @Description 爆炸效果
 * @createTime 2020-11-18 17:00:00
 */
public class Exploades extends BaseExploades {

    public Exploades(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(ResourceMgr.exploades[temp++],x,y,null);
        if(temp>=ResourceMgr.exploades.length){
            tankFrame.exploades.remove(this);
        }
        System.out.println("die");
    }
}
