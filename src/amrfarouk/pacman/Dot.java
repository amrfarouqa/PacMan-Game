package amrfarouk.pacman;



import java.awt.*;


public class Dot extends Entity {
    public Dot() {
        super(StaticBehavior.getInstance(), 100);
    }

    protected Dot(Behavior behavior, int containedScore) {
        super(behavior, containedScore);
    }

    @Override
    public boolean canPassThrough(Entity entity) {
        return !(entity instanceof Wall
                 || entity instanceof Dike);
    }

    @Override
    public boolean canEat(Entity entity) {
        return false;
    }

    @Override
    public void draw(Graphics2D graphics) {
        int halfCell = Math.round((float) getPosition().width / 2.0F);
        int r = getPosition().width / 10;
        graphics.setColor(Color.BLUE);
        graphics.fillOval(halfCell - r,
                          halfCell - r,
                          r * 2,
                          r * 2);
    }
}
