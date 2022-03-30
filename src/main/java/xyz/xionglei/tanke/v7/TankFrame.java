package xyz.xionglei.tanke.v7;

import lombok.Data;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 自定义的Frame.
 *
 * @author xionglei
 * @create 2021-09-08 17:44
 */
@Data
public class TankFrame extends Frame {
    private static final int GAME_WIDTH = 800;
    private static final int GAME_HEIGHT = 600;

    Tank myTank = new Tank(200, 200, Dir.DOWN, this);
    Bullet bullet = new Bullet(100, 0, 10, 10, Color.RED, 5, Dir.DOWN);

    public TankFrame() throws HeadlessException {
        this.setSize(GAME_WIDTH, GAME_HEIGHT);
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
        bullet.paint(g);
    }

    Image offScreenImage = null;

    /**
     * 重写以消除闪屏
     *
     * 当我们调用repaint()方法，它会调用update方法，默认的update方法会调用paint()方法，但由于update方法已经被我们重写
     * @param g 画笔
     */
    @Override
    public void update(Graphics g) {
        if (this.offScreenImage == null) {
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color oldColor = g.getColor(); // 保存原画笔颜色
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);
        gOffScreen.setColor(oldColor);// 设置画笔为原来的原色
        print(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }
}
