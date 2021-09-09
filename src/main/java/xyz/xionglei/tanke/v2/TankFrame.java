package xyz.xionglei.tanke.v2;

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
                // System.out.println("TankFrame.keyReleased");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // System.out.println("TankFrame.keyPressed");
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        // x y表示坐标   width height 显示内容的大小
        g.setColor(new Color(334455));
        System.out.println("TankFrame.paint");
        g.fillRect(x, y, 50, 50);
        x += 30;
        y += 30;
    }
}
