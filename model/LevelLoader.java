package model;


import java.awt.*;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class LevelLoader {
    // Путь к файлу
    private Path path = Paths.get("./src/res/level.txt");


    /**
     * Существует 3 класса - Бабуин, Капуцин и Пустая Клетка
     * * - Бабуин
     * _ - Пустая Клетка
     * @ - Капуцин
     * @return
     */
    public GameObjects getLevel() {
        Map<GameObject, Integer> polygons = new HashMap<>();
        Polygon p;
        try {
            List<String> lines = Files.readAllLines(path);
            int y = 0;
            int x;
            for (String line : lines) {
                x = 0;
                for (Character ch : line.toCharArray()) {
                    p = PolygonHelper.getPolygon(x, y);
                    switch (ch) {
                        case '_':
                            polygons.put(new EmptyBoard(p), (x+1)*10+y+1);
                            break;
                        case '*':
                            polygons.put(new Baboon(p),(x+1)*10+y+1);
                            break;
                        case '@':
                            polygons.put(new Capucin(p), (x+1)*10+y+1);
                            break;
                    }
                    x++;
                }
                y++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new GameObjects(polygons);
    }
}
