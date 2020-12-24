
package amrfarouk.pacman;



import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;


public abstract class Entity {
    private int _containedScore;
    private Behavior _behavior;
    private int _collectedScore;
    private boolean _eaten;
    private Rectangle _position;
    private Space _space;

    private boolean _drawRequired = true;
    private BufferedImage _image;
    private Image _transparentImage;
    private TransparencyFilter _filter = new TransparencyFilter(Color.WHITE);


    protected Entity(Behavior behavior, int containedScore) {
        _behavior = behavior;
        _containedScore = containedScore;
    }

    public final int getCollectedScore() {
        return _collectedScore;
    }

    public Behavior getBehavior() {
        return _behavior;
    }

    void eat(Entity entity) {
        _collectedScore += entity._containedScore;
        entity._eaten = true;
    }

    public boolean isEaten() {
        return _eaten;
    }

    public Direction getNextDirection() {
        return _behavior.nextDirection(_space);
    }

    public Layer getLayer() {
        return Layer.BOTTOM;
    }

    public Rectangle getPosition() {
        return _position;
    }

    public void setPosition(Rectangle position) {
        _position = position;
    }

    public void setSpace(Space space) {
        _space = space;
    }

    public void processIntersection(Entity another) {
        if (canEat(another)) {
            eat(another);
        }
    }

    public final void render(Graphics2D graphics) {
        if (_image == null
            || _image.getWidth() != _position.width
            || _image.getHeight() != _position.height) {
            createImages();
            redraw();
        }

        if (_drawRequired) {
            redrawImage();
        }

        graphics.drawImage(_transparentImage, _position.x, _position.y, null);
    }

    private void redrawImage() {
        Graphics2D graphics = (Graphics2D) _image.getGraphics();

        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, _image.getWidth(), _image.getHeight());

        draw(graphics);

        _transparentImage = makeTransparent(_image);

        _drawRequired = false;
    }

    private void createImages() {
        GraphicsConfiguration configuration = GraphicsEnvironment.getLocalGraphicsEnvironment()
                .getDefaultScreenDevice().getDefaultConfiguration();

        _image = configuration.createCompatibleImage(_position.width,
                                                     _position.height,
                                                     Transparency.BITMASK);
    }

    private Image makeTransparent(Image image) {
        return Toolkit.getDefaultToolkit().createImage(
                new FilteredImageSource(image.getSource(), _filter));
    }

    protected void redraw() {
        _drawRequired = true;
    }

    public abstract boolean canPassThrough(Entity entity);

    protected abstract boolean canEat(Entity entity);

    protected abstract void draw(Graphics2D graphics);
}
