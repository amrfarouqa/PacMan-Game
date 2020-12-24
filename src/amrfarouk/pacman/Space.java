package amrfarouk.pacman;

import java.util.Collection;


public interface Space {
    Collection<Direction> getAvailableDirections();

    Direction getDirectionToward(Class type);
}
