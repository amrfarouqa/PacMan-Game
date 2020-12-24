package amrfarouk.pacman;

import java.awt.*;
import java.awt.image.RGBImageFilter;

class TransparencyFilter extends RGBImageFilter {
    private int _markerRGB;

    TransparencyFilter(Color color) {
        _markerRGB = color.getRGB() | 0xFF000000;
    }

    @Override
    public final int filterRGB(int x, int y, int rgb) {
        return ((rgb | 0xFF000000) == _markerRGB) ? (0x00FFFFFF & rgb) : rgb;
    }
}
