

package amrfarouk.pacman;


import java.awt.*;


public class Dike extends Entity {
    public Dike(Behavior behavior) {
        super(behavior, 0);
    }

    @Override
    public boolean canPassThrough(Entity entity) {
        return !(entity instanceof Wall
                 || entity instanceof Creature
                 || entity instanceof Enemy
                 || entity instanceof Dike
                 || entity instanceof RoamingDot);
    }

    @Override
    public boolean canEat(Entity entity) {
        return false;
    }

    @Override
    public Layer getLayer() {
        return Layer.TOP;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(4, 4, getPosition().width - 8, getPosition().height - 8);
    }
}
