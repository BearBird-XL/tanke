package xyz.xionglei.tanke.v6;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 坦克类
 * @author xionglei
 * @create 2021-09-09 11:23
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Tank {

    // 移动速度
    private static final int SPEED = 10;
    // 位置信息
    private int x, y;
    // 大小信息
    private int width, height;
    // 移动方向
    private Dir dir;
    // 移动还是静止状态
    private boolean moving;
    // 事件
    private TankAdapter tankAdapter = new TankAdapter();

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.setHeight(50).setWidth(50);
    }

    public void paint(Graphics g) {
        // x y表示坐标   width height 显示内容的大小
        g.fillRect(x, y, width, height);
        // 移动
        move();
    }

    // 移动
    private void move() {
        if (moving) {
            switch (dir) {
                case UP:
                    y -= SPEED;
                    break;
                case DOWN:
                    y += SPEED;
                    break;
                case LEFT:
                    x -= SPEED;
                    break;
                case RIGHT:
                    x += SPEED;
                    break;
            }
        }
    }


    private class TankAdapter extends KeyAdapter {
        // 四个布尔值 表示上下左右
        private boolean bU, bD, bR, bL;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
            }
            setMainTankDir();
            setMoving(true);
        }

        private void setMainTankDir() {
            if (bU) {
                dir = Dir.UP;
            }
            if (bD) {
                dir = Dir.DOWN;
            }
            if (bL) {
                dir = Dir.LEFT;
            }
            if (bR) {
                dir = Dir.RIGHT;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            setMoving(false);
            // 释放按键, 值重置
            bU = bD = bL = bR = false;
        }
    }
}
