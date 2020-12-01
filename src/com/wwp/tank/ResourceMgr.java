package com.wwp.tank;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName ResourceMgr.java
 * @Description TODO
 * @createTime 2020-11-18 11:20:00
 */
public class ResourceMgr {
    public static BufferedImage goodTankL,goodTankU,goodTankD,goodTankR;
    public static BufferedImage badTankL,badTankU,badTankD,badTankR;
    public static BufferedImage bulletL,bulletU,bulletD,bulletR;
    public static BufferedImage[] exploades = new BufferedImage[16];
    static {
        try {
            goodTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/GoodTank1.png"));
            goodTankL = ImageUtil.rotateImage(goodTankU,-90);
            goodTankD = ImageUtil.rotateImage(goodTankU,180);
            goodTankR = ImageUtil.rotateImage(goodTankU,90);

            badTankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/BadTank1.png"));
            badTankL = ImageUtil.rotateImage(badTankU,-90);
            badTankD = ImageUtil.rotateImage(badTankU,180);
            badTankR = ImageUtil.rotateImage(badTankU,90);

            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletL =ImageUtil.rotateImage(bulletU,-90);
            bulletD =ImageUtil.rotateImage(bulletU,180);
            bulletR =ImageUtil.rotateImage(bulletU,90);
//            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
//            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
//            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            for (int i = 0; i<exploades.length; i++){
                exploades[i] =ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
