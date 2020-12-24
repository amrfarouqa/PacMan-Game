package amrfarouk.pacman;


import java.util.Comparator;


class LayerComparator implements Comparator<Entity> {
    public int compare(Entity one, Entity another) {
        return one.getLayer().compareTo(another.getLayer());
    }
}
