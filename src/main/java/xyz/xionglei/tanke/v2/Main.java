package xyz.xionglei.tanke.v2;

import java.util.concurrent.TimeUnit;

/**
 * @author xionglei
 * @create 2021-09-08 17:48
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        for (; ; ) {
            TimeUnit.MILLISECONDS.sleep(100);
            tankFrame.repaint();
        }
    }
}
