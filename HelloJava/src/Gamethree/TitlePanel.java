package Gamethree;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class TitlePanel extends JPanel {
    private static final long serialVersionUID = 1L;

    JLabel title;
    JLabel start;
    JLabel exit;
    JLabel select;
    JLabel message;
    Menu checkMenu = Menu.START;
    Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
    MyKeyListener myKeyListener;

    public enum Menu {
        START,
        EXIT,
    }

    TitlePanel() {
        this.setLayout(null);
        this.setBackground(Color.cyan);
    }

    public void prepareComponents() {
        title = new JLabel();
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setVerticalAlignment(SwingConstants.BOTTOM);
        title.setText("Created by Teppu");
        title.setHorizontalTextPosition(JLabel.CENTER);
        title.setVerticalTextPosition(SwingConstants.BOTTOM);
        title.setBounds(90, 0, 600, 350);
        title.setBorder(border);

        start = new JLabel();
        start.setText("START");
        start.setFont(new Font("MV boli", Font.BOLD, 40));
        start.setHorizontalTextPosition(JLabel.CENTER);
        start.setVerticalAlignment(JLabel.BOTTOM);
        start.setBounds(330, 400, 150, 40);
        start.setBorder(border);

        exit = new JLabel();
        exit.setText("EXIT");
        exit.setFont(new Font("MV boli", Font.BOLD, 40));
        exit.setHorizontalTextPosition(JLabel.CENTER);
        exit.setVerticalAlignment(JLabel.BOTTOM);
        exit.setBounds(350, 450, 150, 40);
        exit.setBorder(border);

        select = new JLabel();
        select.setBackground(Color.blue);
        select.setOpaque(true);
        exit.setBounds(280, 400, 40, 40);
        exit.setBorder(border);

        message = new JLabel();
        message.setHorizontalAlignment(SwingConstants.CENTER);
        message.setText("選択:↑,↓   決定:SPACE");
        message.setVerticalTextPosition(JLabel.CENTER);
        message.setHorizontalTextPosition(JLabel.CENTER);
        message.setBounds(249, 517, 300, 30);
        message.setBorder(border);

        this.setLayout(null);
        this.add(title);
        this.add(start);
        this.add(exit);
        this.add(select);
        this.add(message);

        myKeyListener = new MyKeyListener(this);

    }

    private class MyKeyListener implements KeyListener {
        TitlePanel panel;

        MyKeyListener(TitlePanel p) {
            super();
            panel = p;
            panel.addKeyListener(this);
        }

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    if (checkMenu == Menu.EXIT) {
                        select.setLocation(select.getX(), select.getY() + 50);
                        checkMenu = Menu.START;
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (checkMenu == Menu.START) {
                        select.setLocation(select.getX(), select.getY() + 50);
                        checkMenu = Menu.EXIT;
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (checkMenu == Menu.EXIT) {
                        System.exit(0);
                    } else if (checkMenu == Menu.START) {
                        Main.mainWindow.setFrontScreenAndFocus(ScreenMode.GAME);
                    }
                    break;
            }

        }

    }
}
