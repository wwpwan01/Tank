package com.wwp.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName PropertyMsg.java
 * @Description 加载配置文件
 * @createTime 2020-11-20 21:29:00
 */
public class PropertyMsg {
    private static Properties properties = new Properties();
    private static final String URL = "config";
    static {
        try {
            properties.load(PropertyMsg.class.getClassLoader().getResourceAsStream(URL));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String get(String key){
        if(properties == null){
            return null;
        }else {
            return (String) properties.get(key);
        }
    }

    public static void main(String[] args) {
        System.out.println(PropertyMsg.get("initTankNum"));
    }
}
