package amrfarouk.pacman;



import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;


public class LabyrinthDisplay extends JComponent {
    private static final Font INFO_FONT = new Font("Arial", Font.BOLD, 16);
    private static final Font RESULT_FONT = new Font("Arial", Font.BOLD, 42);

    private Labyrinth _labyrinth;
    private FpsCounter _fpsCounter = new FpsCounter();
    

    public LabyrinthDisplay(Labyrinth labyrinth) {
        _labyrinth = labyrinth;

        setFocusable(true);
        setPreferredSize(_labyrinth.getDimensions());
        enableInputMethods(true);
        setDoubleBuffered(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getVisibleRect().width, getVisibleRect().height);

        _labyrinth.render((Graphics2D) g);

        drawScore(g);
        drawFps(g);

        if (_labyrinth.isWin()) {
            drawResult(g, "Win", Color.ORANGE);
        }

        if (_labyrinth.isLose()) {
            drawResult(g, "Lose", Color.RED);
        }
    }

    private void drawScore(Graphics g) {
        drawInfo(g, String.format("Score: %d", _labyrinth.getScore()), 10, 20);
    }

    private void drawFps(Graphics g) {
        String info = String.format("FPS: %3d", _fpsCounter.getFps(System.currentTimeMillis()));

        Dimension infoSize = getSize(g, info);
        Dimension displaySize = getSize();

        drawInfo(g, info, displaySize.width - infoSize.width - 12, 20);
    }

    private Dimension getSize(Graphics g, String string) {
        Rectangle2D bounds = g.getFontMetrics().getStringBounds(string, g);
        return new Dimension((int) bounds.getWidth(),
                             (int) bounds.getHeight());
    }

    private void drawInfo(Graphics g, String info, int x, int y) {
        g.setFont(INFO_FONT);
        Dimension size = getSize(g, info);

        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(x - 5, y - (int) (size.height / 1.2F) - 1,
                   size.width + 10, size.height);

        g.setColor(Color.BLACK);
        g.drawString(info, x, y);
    }

    private void drawResult(Graphics g, String result, Color color) {
        g.setFont(RESULT_FONT);
        Dimension size = getSize(g, result);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, _labyrinth.getDimensions().height / 2
                      - (int) (size.height / 1.2F),
                   _labyrinth.getDimensions().width, size.height);

        g.setColor(color);
        g.drawString(result, (_labyrinth.getDimensions().width - size.width) / 2,
                     _labyrinth.getDimensions().height / 2);
    }

    @Override
    public void invalidate() {
    }

    @Override
    public void validate() {
    }

    @Override
    public void revalidate() {
    }

    @Override
    protected void firePropertyChange(String propertyName, Object oldValue, Object newValue) {
    }

    @Override
    public void firePropertyChange(String propertyName, boolean oldValue, boolean newValue) {
    }
}
