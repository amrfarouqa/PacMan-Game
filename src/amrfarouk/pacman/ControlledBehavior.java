package amrfarouk.pacman;



public class ControlledBehavior extends AbstractBehavior {
    private Direction _nextIntention = Direction.None;


    public void navigate(Direction direction) {
        _nextIntention = direction;
    }

    @Override
    protected void think() {
        if (isDirectionAvailable(_nextIntention)) {
            setIntention(_nextIntention);
        }
    }
}
