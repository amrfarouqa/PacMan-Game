package amrfarouk.pacman;



import java.awt.*;


public class Booster extends Entity {
    public Booster() {
        super(StaticBehavior.getInstance(), 0);
    }

    @Override
    public boolean canPassThrough(Entity entity) {
        return false;
    }

    @Override
    public boolean canEat(Entity entity) {
        return false;
    }

    @Override
    public void draw(Graphics2D graphics) {
        int halfCell = Math.round((float) getPosition().width / 2.0F);

        graphics.setColor(Color.RED);
        graphics.fillRect(halfCell - 1, halfCell / 2, 2, halfCell);
        graphics.fillRect(halfCell / 2, halfCell - 1, halfCell, 2);
    }
}
