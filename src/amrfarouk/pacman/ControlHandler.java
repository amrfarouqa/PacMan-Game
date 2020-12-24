
package amrfarouk.pacman;



import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class ControlHandler extends KeyAdapter {
    private Labyrinth _labyrinth;


    public ControlHandler(Labyrinth labyrinth) {
        _labyrinth = labyrinth;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT:
                _labyrinth.navigate(Direction.Left);
                break;
            case KeyEvent.VK_RIGHT:
                _labyrinth.navigate(Direction.Right);
                break;
            case KeyEvent.VK_UP:
                _labyrinth.navigate(Direction.Up);
                break;
            case KeyEvent.VK_DOWN:
                _labyrinth.navigate(Direction.Down);
                break;
            default:
                // do nothing
        }
    }
}
