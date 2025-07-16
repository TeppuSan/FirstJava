package DeskGameApp;

import javax.swing.JFrame;
import java.awt.BorderLayout;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World");

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        frame.setLocationRelativeTo(null);

        frame.setTitle("Desk Game");

        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        MainLabel mainLabel = new MainLabel();

        MainButton mainButton = new MainButton();

        MainTextArea mainTextArea = new MainTextArea();

        frame.add(mainButton, BorderLayout.NORTH);
        frame.add(mainLabel, BorderLayout.SOUTH);
        frame.add(mainTextArea, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
