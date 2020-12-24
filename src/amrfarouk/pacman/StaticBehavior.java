
package amrfarouk.pacman;




public class StaticBehavior implements Behavior {
    private static final Behavior _instance = new StaticBehavior();


    private StaticBehavior() {
    }

    public static Behavior getInstance() {
        return _instance;
    }

    public Direction nextDirection(Space space) {
        return Direction.None;
    }
}
