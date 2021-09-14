package xyz.xionglei.tanke.v6;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.awt.*;

/**
 * 子弹类
 * @author xionglei
 * @create 2021-09-09 12:09
 */
@Data
@NoArgsConstructor
@Accessors(chain = true)
@AllArgsConstructor
public class Bullet {

    // 子弹位置
    private int x, y;
    // 子弹大下
    private int height, width;
    //颜色
    private Color color;
    // 速度
    private int speed = 10;
    // 方向
    private Dir dir;

    /**
     * 绘制子弹
     * @param g 画笔
     */
    public void paint(Graphics g) {
        // x y表示坐标   width height 显示内容的大小
        Color oldColor = g.getColor();
        g.setColor(color);
        g.fillOval(x, y, width, height);
        // 移动
        g.setColor(oldColor);
        move();
    }

    private void move() {
        switch (dir) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
        }
    }
}
