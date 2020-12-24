package amrfarouk.pacman;


import java.awt.*;


public class Fruit extends Entity {
    private Color _color;


    public Fruit(Color color) {
        super(StaticBehavior.getInstance(), 1000);
        _color = color;
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
        int xSize = getPosition().width / 2;
        int ySize = getPosition().height / 3;
        graphics.setColor(_color);
        graphics.fillOval(getPosition().x + (getPosition().width - xSize) / 2,
                          getPosition().y + (getPosition().height - ySize) / 2,
                          xSize,
                          ySize);
    }
}
