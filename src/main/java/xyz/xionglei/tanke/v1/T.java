package xyz.xionglei.tanke.v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author xionglei
 * @create 2021-09-08 17:37
 */
public class T {

    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setTitle("Maple");
        // 添加时间监听
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
