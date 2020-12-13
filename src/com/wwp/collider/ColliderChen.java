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
public class ColliderChen implements Collider{

    private List<Collider> colliders = new LinkedList<>();

    public ColliderChen(){
        add(new BulletTankCollider());
        add(new TankTankCollider());
    }


    public void add(Collider collider){
        colliders.add(collider);
    }

    @Override
    public boolean collide(GameObject gameObject, GameObject gameObject2) {
        // false  继续下一个责任链
        // true  终止当前责任链
        for (int i = 0; i< colliders.size(); i++){
            if(!colliders.get(i).collide(gameObject,gameObject2)){
                return false;
            }
        }
        return true;
    }
}
