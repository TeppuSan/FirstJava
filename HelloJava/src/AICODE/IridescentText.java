package AICODE;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class IridescentText {
    public static void main(String[] args) throws Exception {
        int width = 300, height = 100;
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();

        // グラデーション（玉虫色風）
        GradientPaint grad = new GradientPaint(0, 0, Color.CYAN, width, height, Color.MAGENTA, true);
        g2.setPaint(grad);
        g2.fillRect(0, 0, width, height);

        // 文字を太く黒で縁取り
        g2.setFont(new Font("Serif", Font.BOLD, 48));
        g2.setColor(Color.BLACK);
        g2.drawString("L(TAT/)I", 29, 69);

        // 文字本体を白で描画
        g2.setColor(Color.WHITE);
        g2.drawString("L(TAT/)I", 30, 70);

        g2.dispose();
        ImageIO.write(img, "png", new File("iridescent_text.png"));
        System.out.println("玉虫色文字画像を生成しました！");
    }
}