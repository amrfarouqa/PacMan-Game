package amrfarouk.pacman;

import javax.swing.*;
import java.io.File;


public class Game {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            runWith(Settings.getDefault());
        } else if (args.length == 4) {
            runWith(settingsFrom(args));
        } else {
            System.err.println("Usage: game.jar [<maze file> <tick period> <cell size> <step size>]");
        }
    }

    private static void runWith(Settings settings) {
        final MainFrame frame = new MainFrame(settings);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                frame.open();
            }
        });
    }

    private static Settings settingsFrom(String[] args) throws Exception {
        return new Settings(new File(args[0]).toURI().toURL(),
                Integer.parseInt(args[1]),
                Integer.parseInt(args[2]),
                Integer.parseInt(args[3]));
    }
}
