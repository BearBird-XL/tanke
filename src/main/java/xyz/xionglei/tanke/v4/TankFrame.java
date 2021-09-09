package xyz.xionglei.tanke.v4;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 自定义的Frame.
 *
 * @author xionglei
 * @create 2021-09-08 17:44
 */
public class TankFrame extends Frame {

    private int x = 200, y = 200;
    // 四个布尔值 表示上下左右
    private boolean bU, bD, bR, bL;
    // 方向
    private Dir dir = Dir.DOWN;
    // 移動速度
    private static final int SPEED = 10;

    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Maple");

        // 添加时间监听
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        this.addKeyListener(new KeyAdapter() {

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
        });
    }

    @Override
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


}
