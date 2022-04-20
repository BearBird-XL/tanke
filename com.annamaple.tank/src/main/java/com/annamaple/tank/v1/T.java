package com.annamaple.tank.v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 认识Frame
 *
 * @author xionglei
 * @create 2022-04-20 20:02
 */
public class T {

    public static void main(String[] args) {
        Frame f = new Frame();
        f.setSize(800, 600);
        // 设置不能改变大下
        f.setResizable(false);
        // 设置标题
        f.setTitle("tank war");
        // 设置点击关闭按钮程序退出
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
        f.setVisible(true);
    }
}
