public class Point {
    //реализуйте геттеры, конструктор и метод toString() в формате:[x, y]
    private final int x, y;


    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return String.format("[%d, %d],",x, y);
    }
    public int getX() {
        return x;
    }

    public int getY() { return y; }

    public double getDistance(Point p2) {
        return Math.sqrt(Math.pow(x - p2.getX(), 2) + Math.pow(y - p2.getY(), 2));
    }
}
