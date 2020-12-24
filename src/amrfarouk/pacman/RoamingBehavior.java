

package amrfarouk.pacman;

public class RoamingBehavior extends AbstractBehavior {
    @Override
    protected void think() {
        if (!isMoving() || !isIntentionDirectionAvailable()) {
            turnToRandomDirection();
        }
    }
}
