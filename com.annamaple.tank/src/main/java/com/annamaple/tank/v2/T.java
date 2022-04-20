package com.annamaple.tank.v2;

import java.awt.*;
import java.util.concurrent.TimeUnit;

/**
 * @author xionglei
 * @create 2022-04-20 20:02
 */
public class T {

    public static void main(String[] args) throws InterruptedException {
        Frame f = new TankFrame();
        for (;;) {
            TimeUnit.MILLISECONDS.sleep(50);
            f.repaint();
        }
    }
}
