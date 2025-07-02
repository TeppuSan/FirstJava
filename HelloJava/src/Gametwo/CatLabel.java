package Gametwo;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class CatLabel extends JLabel {
    private static final long serialVersionUID = 1L;

    Image catImage;

    CatLabel() {
        catImage = new ImageIcon(getClass().getClassLoader().getResource("./Gametwo/eye2.png")).getImage();
        this.setBounds(100, 100, catImage.getWidth(null), catImage.getHeight(null));
    };

    public void paint(Graphics g) {

        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(catImage, 0, 0, catImage.getWidth(null), catImage.getWidth(null), null);
    }
}
