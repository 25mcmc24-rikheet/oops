class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    double distance(Point p) {
        double x0 = x - p.x;
        double y0 = y - p.y;
        return Math.sqrt(x0 * x0 + y0 * y0);
    }
}

class Quadrilateral {
    Point p0, p1, p2, p3;

    Quadrilateral(Point p0, Point p1, Point p2, Point p3) {
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    double perimeter() {
        return p0.distance(p1) + p1.distance(p2) + p2.distance(p3) + p3.distance(p0);
    }

    double area() {
        return 0;
    }
}

class Trapezoid extends Quadrilateral {
    Trapezoid(Point p0, Point p1, Point p2, Point p3) {
        super(p0, p1, p2, p3);
    }

    @Override
    double area() {
        double side1 = p0.distance(p1);
        double side2 = p2.distance(p3);
        double height = Math.abs(p3.y - p0.y);
        return (side1 + side2) * height / 2;
    }
}

class Parallelogram extends Trapezoid {
    Parallelogram(Point bottom_left, Point top_left, double base) {
        super(
            bottom_left, 
            new Point(bottom_left.x + base, bottom_left.y), 
            new Point(top_left.x + base, top_left.y), 
            top_left
        );
    }
}

class Rectangle extends Parallelogram {
    Rectangle(Point bottom_left, double length, double breadth) {
        super(
            bottom_left, 
            new Point(bottom_left.x, bottom_left.y + breadth), 
            length
        );
    }

    @Override
    double area() {
        double length = p0.distance(p1);
        double breadth = p0.distance(p3);
        return length * breadth;
    }
}

class Square extends Rectangle {
    Square(Point bottom_left, double side) {
        super(bottom_left, side, side);
    }
}

public class inheritance {
    public static void main(String[] args) {
        Quadrilateral shapes[] = new Quadrilateral[4];

        shapes[0] = new Square(new Point(-2, -2), 8);
        shapes[1] = new Rectangle(new Point(-5, 1), 6.5, 3.2);
        shapes[2] = new Parallelogram(new Point(-3, -2), new Point(-1, 3), 3);
        shapes[3] = new Trapezoid(new Point(2, -3), new Point(8, -3), new Point(6, 0), new Point(2, 0));

        for (int i = 0; i < shapes.length; i++) {
            System.out.println(shapes[i].getClass().getSimpleName());
            System.out.println("Perimeter = " + shapes[i].perimeter());
            System.out.println("Area = " + shapes[i].area());
            System.out.println();
        }
    }
}