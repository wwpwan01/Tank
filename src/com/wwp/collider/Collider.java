package com.wwp.collider;

import com.wwp.tank.GameObject;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName Collider.java
 * @Description 碰撞器接口
 * @createTime 2020-12-10 21:41:00
 */
public interface Collider {
    boolean collide(GameObject g1, GameObject g2);
}
