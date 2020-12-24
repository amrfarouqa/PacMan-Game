package amrfarouk.pacman;

import java.awt.*;


public enum Direction {
    None(0, 0),
    Left(-1, 0),
    Right(1, 0),
    Up(0, -1),
    Down(0, 1);

    public static final Direction[] MOVING_DIRECTIONS = {Left, Right, Up, Down};
    private Point _vector;


    Direction(int x, int y) {
        _vector = new Point(x, y);
    }

    public Rectangle translate(Rectangle rectanle, int distance) {
        Rectangle result = new Rectangle(rectanle);
        result.translate(_vector.x * distance, _vector.y * distance);
        return result;
    }

    public boolean isPerpendicular(Direction direction) {
        if ((Left.equals(this) || Right.equals(this))
            && (Up.equals(direction) || Down.equals(direction))) {
            return true;
        }

        if ((Up.equals(this) || Down.equals(this))
            && (Left.equals(direction) || Right.equals(direction))) {
            return true;
        }

        return false;
    }
}
