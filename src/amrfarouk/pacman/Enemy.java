

package amrfarouk.pacman;


import java.awt.*;


public class Enemy extends Entity {
    private Color _color;


    public Enemy(Behavior behavior, Color color) {
        super(behavior, 5000);
        _color = color;
    }

    @Override
    public boolean canPassThrough(Entity entity) {
        return !(entity instanceof Wall
                 || entity instanceof Dike);
    }

    @Override
    public boolean canEat(Entity entity) {
        return entity instanceof Creature &&
               !((Creature) entity).isBoosted();
    }

    @Override
    public void draw(Graphics2D graphics) {
        int halfCell = Math.round((float) getPosition().width / 2.0F);
        int r = getPosition().width / 3;
        graphics.setColor(_color);
        graphics.fillOval(+ halfCell - r,
                          + halfCell - r,
                          r * 2,
                          r * 2);

        int crossRadius = r / 2;
        graphics.setColor(Color.BLACK);
        graphics.drawLine(halfCell - crossRadius,
                          halfCell - crossRadius,
                          halfCell + crossRadius,
                          halfCell + crossRadius);
        graphics.drawLine(halfCell - crossRadius - 1,
                          halfCell - crossRadius + 1,
                          halfCell + crossRadius + 1,
                          halfCell + crossRadius - 1);

        graphics.drawLine(halfCell + crossRadius,
                          halfCell - crossRadius,
                          halfCell - crossRadius,
                          halfCell + crossRadius);
        graphics.drawLine(halfCell + crossRadius - 1,
                          halfCell - crossRadius - 1,
                          halfCell - crossRadius + 1,
                          halfCell + crossRadius + 1);
    }

    @Override
    public Layer getLayer() {
        return Layer.TOP;
    }
}
