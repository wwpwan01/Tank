package com.wwp.collider;

import com.wwp.tank.Bullet;
import com.wwp.tank.GameObject;
import com.wwp.tank.Tank;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName TankTankCollider.java
 * @Description 坦克和坦克碰撞器
 * @createTime 2020-12-10 21:51:00
 */
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject g1, GameObject g2) {
        if (g1 instanceof Tank && g2 instanceof Tank) {

            Tank tank = (Tank) g1;
            Tank tank2 = (Tank) g2;
            //区分敌我，不伤害队友
            if (tank.getGroup() == tank2.getGroup()) {

                if ((tank2.rectangle.intersects(tank.rectangle) || tank.rectangle.intersects(tank2.rectangle)) && tank2.getGroup() == tank.getGroup()) {
                    System.out.println("坦克撞到了坦克-------");
//                    tank.die();
//                    bullet.die();
//                    int ex = tank.getX() + Tank.WIDTH / 2 - Exploades.WIDTH / 2;
//                    int ey = tank.getY() + Tank.HEIGHT / 2 - Exploades.HEIGHT / 2;
//                    gm.add(new Exploades(ex, ey, gm));
//                    tank2.returnLastDir(tank.getDir());
//                    tank.returnLastDir(tank.getX(),tank.getY(),tank.getDir());
                    tank.stop();
                    tank2.stop();
                    return false;
                }
            }
        }
        return true;
    }
}
