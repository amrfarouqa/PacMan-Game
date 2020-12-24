package amrfarouk.pacman;



import java.awt.*;


public class ImmortalEnemy extends Enemy {
    public ImmortalEnemy(Behavior behavior, Color color) {
        super(behavior, color);
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Creature;
    }

    @Override
    public void draw(Graphics2D graphics) {
        super.draw(graphics);

        graphics.setColor(Color.RED);

        final int inset = 4;
        graphics.drawOval(inset, inset,
                          getPosition().width - inset * 2,
                          getPosition().height - inset * 2);
    }
}
