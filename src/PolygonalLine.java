import java.util.ArrayList;

public class PolygonalLine {
    private ArrayList<Point> points = new ArrayList<>();

    public double getLength() {
        //реализуйте метод получение длины ломаной линии
        if (points.size() > 2) {
            double len = 0;
            for (int i = 0; i < points.size() - 1; ++i) {
                len += points.get(i).getDistance(points.get(i + 1));
            }
            return len;
        } else {
            return 0;
        }

    }

    public void addPoint(Point p) {
        //реализуйте метод добавления точки
        points.add(p);
    }

    public void setPoints(ArrayList<Line> lines) {
        //инициализация ломаной линии с помощью листа линий
        for (Line line: lines) {
            points.add(line.getStartPoint());
            points.add(line.getEndPoint());
        }
    }
}
