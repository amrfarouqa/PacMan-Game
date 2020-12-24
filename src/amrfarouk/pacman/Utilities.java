package amrfarouk.pacman;

import java.awt.*;
import java.util.Collection;
import java.util.Random;


public class Utilities {
    private static final Random _random = new Random();

    private Utilities() {
    }

    public static <T> T chooseElement(T[] elements) {
        return chooseElement(elements, null);
    }

    public static <T> T chooseElement(Collection<T> elements, T alternative) {
        return chooseElement((T[]) (elements.toArray()), alternative);
    }

    public static <T> T chooseElement(T[] elements, T alternative) {
        if (elements.length == 0) {
            return alternative;
        } else {
            int choiceIndex = _random.nextInt(elements.length);
            return elements[choiceIndex];
        }
    }

    public static void centerOnScreen(Window window) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension size = window.getSize();
        window.setLocation(
                (screenSize.width - size.width) / 2,
                (screenSize.height - size.height) / 2);
    }
}
