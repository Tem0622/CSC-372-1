package Week4;

public class Cone extends Shape {
    private double radius;
    private double height;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    @Override
    public double surfaceArea() {
        double slantHeight = Math.sqrt(radius * radius + height * height);
        return Math.PI * radius * (radius + slantHeight);
    }

    @Override
    public double volume() {
        return Math.PI * radius * radius * height / 3;
    }

    @Override
    public String toString() {
        return "Cone [surface area = " + surfaceArea() + ", volume = " + volume() + "]";
    }
}
