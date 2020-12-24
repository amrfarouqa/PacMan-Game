package amrfarouk.pacman;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;


class LabyrinthLoader {
    private static final EntityFactory _factory = new EntityFactory();
    private Entity _controlledEntity;


    Labyrinth load(URL url, int cellSize, int stepSize) {
        BufferedReader reader = null;
        try {
            try {
                reader = new BufferedReader(new InputStreamReader(url.openStream()));
                return read(reader, cellSize, stepSize);
            } finally {
                if (reader != null) {
                    reader.close();
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Labyrinth read(BufferedReader reader, int cellSize, int stepSize) throws IOException {
        Labyrinth labyrinth = new Labyrinth(cellSize, stepSize);

        int row = 0;
        while (reader.ready()) {
            char[] chars = reader.readLine().toCharArray();

            int column = 0;
            for (char aChar : chars) {
                Entity entity = createEntity(aChar);
                labyrinth.add(entity, new Point(column, row));

                column++;
            }

            row++;
        }

        labyrinth.setControlledEntity(_controlledEntity);

        return labyrinth;
    }

    private Entity createEntity(char character) {
        switch (character) {
            case 'C':
                _controlledEntity = _factory.createCreature();
                return _controlledEntity;
            case 'E':
                return _factory.createEnemy();
            case 'I':
                return _factory.createImmortalEnemy();
            case 'S':
                return _factory.createSmartEnemy();
            case 'F':
                return _factory.createFruit();
            case '.':
                return _factory.createDot();
            case 'D':
                return _factory.createDike();
            case 'R':
                return _factory.createRoamingDot();
            case 'B':
                return _factory.createBooster();
            case '#':
                return _factory.createWall();
            default:
                throw new RuntimeException(
                        "Unknown entity: '" + character + "'");
        }
    }
}
