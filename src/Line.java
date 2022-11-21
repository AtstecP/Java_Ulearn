import java.util.ArrayList;
//ArrayList<Line> lines = new ArrayList<>();
//        lines.add(new Line(new Point(0, 0), new Point(0, 5)));
//        lines.add(new Line(new Point(0, 5), new Point(5, 5)));
//        lines.add(new Line(new Point(5, 5), new Point(5, 0)));
//        lines.add(new Line(new Point(5, 0), new Point(0, 0)));
//
//        PolygonalLine polline = new PolygonalLine();
//        polline.setPoints(lines);
//        System.out.println(polline.getLength());
public class Line {
    //реализуйте получение стартовой точки, конечной, toString() в формате: [x, y], [x1, y1], GetLength() и hasPoint()
    private Point p1, p2;
    private double len;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
        len = p1.getDistance(p2);
    }

    public double getLength() {
        return len;
    }

    public boolean hasPoint(Point p) {
        System.out.println(p1.getDistance(p));
        System.out.println(p.getDistance(p2));

        if (p1.getDistance(p) + p.getDistance(p2) == len)
            return true;
        else
            return false;
    }


    public Point getStartPoint() {
        return p1;
    }


    public Point getEndPoint() {
        return p2;
    }

    @Override
    public String toString() {
        return String.format("[%d, %d], [%d, %d]",p1.getX(), p1.getY(), p2.getX(), p2.getY());
    }
}

