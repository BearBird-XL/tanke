package xyz.xionglei.tanke.v6;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 主类.启动类
 *
 * @author xionglei
 * @create 2021-09-08 17:48
 */
public class Main {

    public static void main(String[] args) {
        TankFrame tankFrame = new TankFrame();
        ScheduledExecutorService threadPool = Executors.newScheduledThreadPool(1);
        threadPool.scheduleWithFixedDelay(tankFrame::repaint, 500, 50, TimeUnit.MILLISECONDS);
    }
}
