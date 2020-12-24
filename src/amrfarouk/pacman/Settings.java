package amrfarouk.pacman;


import java.net.URL;


class Settings {
    private URL _url;
    private int _tickPeriod;
    private int _cellSize;
    private int _stepSize;

    
    Settings(URL url, int tickPeriod, int cellSize, int stepSize) {
        _url = url;
        _tickPeriod = tickPeriod;
        _cellSize = cellSize;
        _stepSize = stepSize;
    }

    public URL getURL() {
        return _url;
    }

    public int getTickPeriod() {
        return _tickPeriod;
    }

    public int getCellSize() {
        return _cellSize;
    }

    public int getStepSize() {
        return _stepSize;
    }
    
    static Settings getDefault() {
        return new Settings(MainFrame.class.getResource("/maze.txt"), 10, 36, 2);
    }
}
