package xyz.xionglei.tanke.v5;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * @author xionglei
 * @create 2021-09-09 11:23
 */

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Tank {

    private static final int SPEED = 10;
    private int x, y;
    private Dir dir;
    private TankAdapter tankAdapter = new TankAdapter();

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        // x y表示坐标   width height 显示内容的大小
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
        g.fillRect(x, y, 50, 50);
    }

    private class TankAdapter extends KeyAdapter {
        // 四个布尔值 表示上下左右
        private boolean bU, bD, bR, bL;

        @Override
        public void keyReleased(KeyEvent e) {
            // 释放按键, 值重置
            bU = bD = bL = bR = false;
        }

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
    }
}
