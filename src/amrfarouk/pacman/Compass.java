package amrfarouk.pacman;


import java.awt.*;
import java.util.HashMap;
import java.util.Map;


class Compass {
    private Labyrinth _labyrinth;
    private Entity _entity;
    private Class _type;

    private Map<Rectangle, Direction> _edges;
    private Map<Rectangle, Direction> _traces;


    Compass(Labyrinth labyrinth, Entity entity, Class type) {
        _entity = entity;
        _labyrinth = labyrinth;
        _type = type;
    }

    public Direction locate() {
        _edges = new HashMap<Rectangle, Direction>();
        _traces = new HashMap<Rectangle, Direction>();

        initialSplash(_entity.getPosition());

        do {
            Direction mark = getTouch();
            if (mark != null) {
                return mark;
            }

            flow();
        } while (isSpaceLeft());

        return Direction.None;
    }

    private void initialSplash(Rectangle position) {
        for (Direction direction : Direction.MOVING_DIRECTIONS) {
            raise(_labyrinth.translate(position, direction), direction);
        }
    }

    private void splash(Rectangle position, Direction mark) {
        for (Direction direction : Direction.MOVING_DIRECTIONS) {
            raise(_labyrinth.translate(position, direction), mark);
        }
    }

    private void raise(Rectangle target, Direction mark) {
        if (isNotInTrace(target) && isAvailable(target)) {
            _edges.put(target, mark);
        }
    }

    private void fall(Rectangle position, Direction mark) {
        _traces.put(position, mark);
        _edges.remove(position);
    }

    private void flow() {
        Map<Rectangle, Direction> edges
                = new HashMap<Rectangle, Direction>(_edges);

        for (Map.Entry<Rectangle, Direction> edge : edges.entrySet()) {
            Rectangle position = edge.getKey();
            Direction mark = edge.getValue();
            fall(position, mark);
            splash(position, mark);
        }
    }

    private Direction getTouch() {
        for (Map.Entry<Rectangle, Direction> edge : _edges.entrySet()) {
            if (_labyrinth.isIntersects(edge.getKey(), _type)) {
                return edge.getValue();
            }
        }
        return null;
    }

    private boolean isAvailable(Rectangle position) {
        return _labyrinth.canBeAt(_entity, position);
    }

    private boolean isNotInTrace(Rectangle position) {
        return !_traces.containsKey(position);
    }

    private boolean isSpaceLeft() {
        return _edges.size() > 0;
    }
}
