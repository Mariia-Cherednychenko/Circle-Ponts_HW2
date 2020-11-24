package ua.ithlillel.dnipro.Cherednychenko;

public class Circle {

    private Point center;
    private double radius;

    public Circle() {
    }

    public Circle(Point center, double radius) {
        setCenter(center);
        setRadius(radius);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius > 0) {
            this.radius = radius;
        }
        else new Exception();
    }

    public  double getDistanceBetweenPoints (Point p){
        return  (Math.sqrt( Math.pow((this.center.getX()-p.getX()),2)+ Math.pow((this.center.getY()-p.getY()),2)));
    }

}
