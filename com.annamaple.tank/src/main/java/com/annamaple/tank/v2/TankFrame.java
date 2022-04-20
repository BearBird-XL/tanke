package com.annamaple.tank.v2;

import cn.hutool.core.lang.Console;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * 集成Frame,重写Frame
 *
 * @author xionglei
 * @create 2022-04-20 20:11
 */
public class TankFrame extends Frame {

    int x = 200, y = 200;

    /**
     * 无参构造
     */
    public TankFrame() throws HeadlessException {
        this.setSize(800, 600);
        // 设置不能改变大下
        this.setResizable(false);
        // 设置标题
        this.setTitle("tank war");
        // 设置可见
        this.setVisible(true);
        // 设置点击关闭按钮程序退出
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowClosing(e);
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Console.log("paint x:{} y:{}", x, y);
        // 填充一个矩形
        g.fillRect(x, y, 50, 50);
        x += 10;
        y += 10;
    }
}
