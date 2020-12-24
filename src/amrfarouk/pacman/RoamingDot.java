package amrfarouk.pacman;


import java.awt.*;


public class RoamingDot extends Dot {
    public RoamingDot(Behavior behavior) {
        super(behavior, 500);
    }

    @Override
    public Layer getLayer() {
        return Layer.BOTTOM;
    }

    @Override
    public void draw(Graphics2D graphics) {
        int halfCell = Math.round((float) getPosition().width / 2.0F);
        int r = getPosition().width / 7;
        graphics.setColor(Color.BLUE);
        graphics.fillOval(halfCell - r,
                          halfCell - r,
                          r * 2,
                          r * 2);
    }
}
