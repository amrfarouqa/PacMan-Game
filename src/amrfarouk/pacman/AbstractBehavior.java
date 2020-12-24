
package amrfarouk.pacman;



import java.util.Collection;


public abstract class AbstractBehavior implements Behavior {
    private Direction _intention = Direction.None;
    private Collection<Direction> _availableDirections;
    private Space _space;


    public Direction nextDirection(Space space) {
        _space = space;
        _availableDirections = _space.getAvailableDirections();

        think();

        if (!isIntentionDirectionAvailable()) {
            setIntention(Direction.None);
        }

        return _intention;
    }

    protected boolean isDirectionAvailable(Direction direction) {
        return _availableDirections.contains(direction);
    }

    protected boolean isIntentionDirectionAvailable() {
        return isDirectionAvailable(_intention);
    }

    protected boolean isIntentionPerpendicualrTo(Direction direction) {
        return _intention.isPerpendicular(direction);
    }

    protected boolean isPerpendicularTurnsAvailable() {
        for (Direction direction : _availableDirections) {
            if (_intention.isPerpendicular(direction)) {
                return true;
            }
        }

        return false;
    }

    public void setIntention(Direction intention) {
        _intention = intention;
    }

    protected void turnToRandomDirection() {
        _intention = randomDirection();
    }

    protected Direction randomDirection() {
        return Utilities.chooseElement(_availableDirections, Direction.None);
    }

    protected boolean isMoving() {
        return !Direction.None.equals(_intention);
    }

    protected void turnToward(Class type) {
        setIntention(_space.getDirectionToward(type));
    }

    protected abstract void think();
}
