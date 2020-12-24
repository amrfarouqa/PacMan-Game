
package amrfarouk.pacman;




public class DirectedBehavior extends AbstractBehavior {
    @Override
    protected void think() {
        if (!isMoving()
            || !isIntentionDirectionAvailable()
            || isPerpendicularTurnsAvailable()) {
            turnToward(Creature.class);
        }
    }
}
