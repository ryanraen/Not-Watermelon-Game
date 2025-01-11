package main.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class NotWatermelonGame extends JFrame {

    // SYSTEM
    public static final int DELTA = 10;
    public static final int SCREEN_WIDTH = 600;
    public static final int SCREEN_HEIGHT = 800;

    GamePanel gp;

    public NotWatermelonGame() {
        gp = new GamePanel(SCREEN_WIDTH, SCREEN_HEIGHT);
        init();
        createGameLoop();
    }

    private void init() {
        this.setTitle("Not Watermelon Game");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        // this.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        // this.setBackground(Color.BLACK);
        this.add(gp);
        this.pack();

        this.setVisible(true);
    }

    private void createGameLoop() {
        Timer timer = new Timer(DELTA, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gp.repaint();
            }
        });

        timer.start();
    }
    public static void main(String[] args) throws Exception {
        new NotWatermelonGame();
    }
}
