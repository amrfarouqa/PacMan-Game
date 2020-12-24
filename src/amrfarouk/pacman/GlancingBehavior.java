
package amrfarouk.pacman;




public class GlancingBehavior extends RoamingBehavior {
    private static final double GLANCE_PROBABILITY = 0.5D;


    @Override
    protected void think() {
        if (isIntentionDirectionAvailable()) {
            if ((Math.random() < GLANCE_PROBABILITY)) {
                glance();
            }
        } else {
            super.think();
        }
    }

    private void glance() {
        if (isPerpendicularTurnsAvailable()) {
            for (Direction direction : Direction.MOVING_DIRECTIONS) {
                if (isIntentionPerpendicualrTo(direction) &&
                    isDirectionAvailable(direction)) {
                    setIntention(direction);
                    return;
                }
            }
        }
    }
}
