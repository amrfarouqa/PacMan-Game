package amrfarouk.pacman;

public class RandomBehavior extends RoamingBehavior {
    private static final double TURN_PROBABILITY = 0.01D;


    @Override
    protected void think() {
        super.think();

        if (Math.random() < TURN_PROBABILITY) {
            turnToRandomDirection();
        }
    }
}
