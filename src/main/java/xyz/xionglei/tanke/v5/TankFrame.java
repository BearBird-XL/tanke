package xyz.xionglei.tanke.v5;

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

    Tank myTank = new Tank(200, 200, Dir.STOP);

    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
        this.setResizable(false);
        this.setVisible(true);
        this.setTitle("Maple");

        // 添加监听
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.addKeyListener(myTank.getTankAdapter());
    }

    @Override
    public void paint(Graphics g) {
        myTank.paint(g);
    }
}
