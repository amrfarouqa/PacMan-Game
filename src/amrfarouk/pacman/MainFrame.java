package amrfarouk.pacman;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class MainFrame extends JFrame {
    private Labyrinth _labyrinth;
    private LabyrinthDisplay _display;
    private Timer _timer;


    MainFrame(Settings settings) {
        super("Game");

        _labyrinth = new LabyrinthLoader().load(settings.getURL(), settings.getCellSize(), settings.getStepSize());
        _display = new LabyrinthDisplay(_labyrinth);
        getContentPane().add(_display);

        _display.addKeyListener(new ControlHandler(_labyrinth));

        _timer = new Timer(settings.getTickPeriod(), new TimerListener());
    }

    public void open() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setResizable(false);
        Utilities.centerOnScreen(this);
        setVisible(true);
        _timer.start();
    }

    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            _labyrinth.processTick();
            _display.repaint();

            if (_labyrinth.isWin() || _labyrinth.isLose()) {
                _timer.stop();
            }
        }
    }
}
