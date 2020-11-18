package com.wwp.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author wwp
 * @version 1.0.0
 * @program tanke
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2020-11-18 10:43:00
 */
public class Test {

    public static void main(String[] args) {
        try {
            BufferedImage read = ImageIO.read(Test.class.getClassLoader().getResourceAsStream("images/4.gif"));
            System.out.println(read);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
