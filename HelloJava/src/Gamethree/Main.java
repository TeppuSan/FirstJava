package Gamethree;

public class Main {
    static MainWindow mainWindow;

    public static void main(String[] args) {
        mainWindow = new MainWindow();
        mainWindow.preparePanels();
        mainWindow.prepareComponents();
        mainWindow.setFrontScreenAndFocus(ScreenMode.MAIN);
        mainWindow.setVisible(true);
    }

}
