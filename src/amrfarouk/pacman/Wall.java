package amrfarouk.pacman;


import java.awt.*;


public class Wall extends Entity {
    public Wall() {
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
        graphics.setColor(Color.BLACK);
        graphics.fillRect(1,
                          1,
                          getPosition().width - 2,
                          getPosition().height - 2);
    }
}
