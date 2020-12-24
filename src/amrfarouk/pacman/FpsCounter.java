

package amrfarouk.pacman;

class FpsCounter {
    private static final int PERIOD = 1;

    private long _last;
    private int _frames;
    private int _fps;


    public int getFps(long time) {
        _frames++;

        int seconds = (int) ((time - _last) / 1000L);

        if (seconds >= PERIOD) {
            _fps = _frames / seconds;

            _frames = 0;
            _last = time;
        }

        return _fps;
    }
}
