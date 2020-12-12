package com.wwp.strategy;

import com.wwp.tank.GameModle;

/**
 * @author wwp
 * @version 1.0.0
 * @program Tank
 * @ClassName BulletStrategy.java
 * @Description 子弹发射策略接口
 * @createTime 2020-11-22 19:18:00
 */
public interface BulletStrategy<T> {

    void fir(T tank, GameModle tankFrame);
}
