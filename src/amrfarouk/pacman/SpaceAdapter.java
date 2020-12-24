package amrfarouk.pacman;


import java.util.Collection;


class SpaceAdapter implements Space {
    private Labyrinth _labyrinth;
    private Entity _entity;


    SpaceAdapter(Labyrinth labyrinth, Entity entity) {
        _labyrinth = labyrinth;
        _entity = entity;
    }

    public Collection<Direction> getAvailableDirections() {
        return _labyrinth.getAvailableDirections(_entity);
    }

    public Direction getDirectionToward(Class type) {
        return _labyrinth.getDirectionToward(_entity, type);
    }
}
