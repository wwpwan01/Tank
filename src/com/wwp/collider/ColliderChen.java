package com.wwp.collider;

import com.wwp.tank.GameObject;

import java.util.LinkedList;
import java.util.List;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName ColliderChen.java
 * @Description 责任链模式
 * @createTime 2020-12-10 21:50:00
 */
public class ColliderChen {

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChen(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }


    public void add(Collider collider){
        colliders.add(collider);
    }

    public void collde(GameObject gameObject, GameObject gameObject2) {
        for (int i = 0; i< colliders.size(); i++){
            colliders.get(i).collide(gameObject,gameObject2);
        }
    }
}
