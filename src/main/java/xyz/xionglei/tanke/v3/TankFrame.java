package xyz.xionglei.tanke.v3;

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

    int x = 200, y = 200;
    // 四个布尔值 表示上下左右
    boolean bU, bD, bR, bL;

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
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // x y表示坐标   width height 显示内容的大小
        int p = 20;
        if (bU) {
            y -= p;
        }
        if (bD) {
            y += p;
        }
        if (bL) {
            x -= p;
        }
        if (bR) {
            x += p;
        }
        g.fillRect(x, y, 50, 50);
    }
}
