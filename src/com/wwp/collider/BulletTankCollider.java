package com.wwp.collider;

import com.wwp.tank.Bullet;
import com.wwp.tank.Exploades;
import com.wwp.tank.GameObject;
import com.wwp.tank.Tank;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BulletTankCollider.java
 * @Description 子弹和坦克碰撞器
 * @createTime 2020-12-10 21:42:00
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject g1, GameObject g2) {
        if (g1 instanceof Bullet && g2 instanceof Tank) {
            Bullet bullet = (Bullet) g1;
            Tank tank = (Tank) g2;
            //区分敌我，不伤害队友
            if (tank.getGroup() == bullet.getGroup()) {
                return true;
            } else {
                if (bullet.rectangle.intersects(tank.rectangle)) {
                    System.out.println("撞到了-------");
                    bullet.die();
                    int ex = tank.getX() + Tank.WIDTH / 2 - Exploades.WIDTH / 2;
                    int ey = tank.getY() + Tank.HEIGHT / 2 - Exploades.HEIGHT / 2;
                    tank.die();
                    tank.exploades(new Exploades(ex, ey, tank.getGm()));
                    return false;
                }
            }
        }
        if (g2 instanceof Bullet && g1 instanceof Tank) {
            collide(g2,g1);
        }
        return true;
    }
}
