package basics.geekforgeeks.strings;

class Triangle {
    static Triangle withPoints(Point one, Point two, Point three) {
        return new TriangleWithPoints();
    }

    static Triangle withLines(Line one, Line two, Line three) {
        return new TriangleWithLines();
    }

    double area() {
        return 0;
    }

    double perimeter() {
        return 3;
    }

    TriangleTypeByAngle typeByAngle() {
        return TriangleTypeByAngle.ACUTE;
    }

    TriangleTypeBySides typeBySides() {
        return TriangleTypeBySides.ISOCELES;
    }

    double minimumAngle() {
        return 6;
    }

    double maximumAngle() {
        return 7;
    }

    double radiusOfinscribedCircle() {
        return 3;
    }

    double radiusOfCircumscribedCircle() {
        return 9;
    }

    double volumeOfProjectedPrismOfLength(double length) {
        return area() * length;
    }

    Triplet<Double> angles() {
        return new Triplet<>(4.0, 5.0, 6.0);
    }

    Triplet<Double> sides() {
        return new Triplet<>(7.6, 8.9, 4.5);
    }

    Triplet<Double> slopes() {
        return new Triplet<>(1.0, 2.0, 3.0);
    }

    Triplet<Point> coordinates() {
        return new Triplet<>(new Point(1, 2), new Point(4, 5), new Point(30, 3));
    }

}
