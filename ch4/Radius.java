package ch4;

public class Radius {
    double radius;
    double height;
    double width;

    public void getCircle() {
        System.out.println("원의 넓이는 : " + (radius * radius * 3.14));
    }

    public void getRactangle() {
        System.out.println("사각형의 넓이는 : " + height * width);
    }

    public Radius() {
        radius = 2.5;
        height = 5.0;
        width = 3.0;
    }

    public Radius(double radius) {
        this.radius = radius;
        this.height = 5.0; // 기본값
        this.width = 3.0; // 기본값
    }

    public Radius(double height, double width) {
        this.radius = 2.5; // 기본값
        this.height = height;
        this.width = width;
    }

    public Radius(double radius, double height, double width) {
        this.radius = radius;
        this.height = height;
        this.width = width;
    }

}
