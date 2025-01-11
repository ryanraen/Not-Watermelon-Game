package main.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class GamePanel extends JPanel {

    public final Color BG_COLOR = Color.BLACK;
    public final Color BORDER_COLOR = Color.WHITE;
    public final Color DOTTED_COLOR = Color.GRAY;

    public final int BORDER_WIDTH = 5;

    public final int DOTTED_WIDTH = 10;
    public final int DOTTED_HEIGHT = 3;

    public int screenWidth;
    public int screenHeight;

    public int borderMargin;
    public int borderMarginTop;
    public int borderHeightVertical;
    public int borderHeightHorizontal;

    public int numberDots;
    public int dottedY;

    public GamePanel(int screenWidth, int screenHeight) {

        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;

        borderMargin = screenWidth / 8;
        borderMarginTop = 2 * borderMargin;
        borderHeightVertical = screenHeight - borderMargin - borderMarginTop;
        borderHeightHorizontal = screenWidth - 2 * borderMargin - 1;

        numberDots = screenWidth / (2 * DOTTED_WIDTH);
        dottedY = borderMarginTop - borderMarginTop / 10;

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(BG_COLOR);
    }

    public void drawBorder(Graphics g) {
        g.setColor(BORDER_COLOR);

        // DRAWS LEFT BORDER
        g.fillRect(
                borderMargin,
                borderMarginTop,
                BORDER_WIDTH,
                borderHeightVertical);

        // DRAWS RIGHT BORDER
        g.fillRect(
                screenWidth - borderMargin - BORDER_WIDTH - 1,
                borderMarginTop,
                BORDER_WIDTH,
                borderHeightVertical);

        // DRAWS BOTTOM BORDER
        g.fillRect(
                borderMargin,
                screenHeight - borderMargin - BORDER_WIDTH,
                borderHeightHorizontal,
                BORDER_WIDTH);

        // DRAWS DOTTED LINE
        g.setColor(DOTTED_COLOR);
        for (int i = 0; i < numberDots; i++) {
            g.fillRect(
                    DOTTED_WIDTH / 2 + 2 * i * DOTTED_WIDTH,
                    dottedY,
                    DOTTED_WIDTH,
                    DOTTED_HEIGHT);
        }

    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBorder(g);
    }

}
