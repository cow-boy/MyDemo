package com.example.demo;/**
 * Created by huxu on 2017/9/3.
 */

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * 在图片上绘制文字
 *
 * @author HUXU
 * @create 2017-09-03 1:54
 **/

public class Graphics2DTest {

    public static void main(String[] args) {
        try {
            String text = "文字居中";
            int width = 500;
            int height = 400;
            // 创建BufferedImage对象
            BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
            // 获取Graphics2D
            Graphics2D g2d = image.createGraphics();
            // 画图
            g2d.setBackground(new Color(255,255,255));
            //g2d.setPaint(new Color(0,0,0));
            g2d.setColor(Color.red);
            g2d.clearRect(0, 0, width, height);
            Font font=new Font("宋体",Font.PLAIN,64);
            g2d.setFont(font);
            // 抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            // 计算文字长度，计算居中的x点坐标
            FontMetrics fm = g2d.getFontMetrics(font);
            int textWidth = fm.stringWidth(text);
            int widthX = (width - textWidth) / 2;
            // 表示这段文字在图片上的位置(x,y) .第一个是你设置的内容。
            g2d.drawString(text,widthX,100);
            // 释放对象
            g2d.dispose();
            // 保存文件
            ImageIO.write(image, "jpg", new File("D:/test.jpg"));
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
