package com.bebra;

public class Main {
    public static void main(String[] args) {
        double x = 1.0;
        double y = 2.0;
        double r = 3.0;
        PointResultController controller = new PointResultController();
        PointResult point = controller.createPointResult(x, y, r);
        String answer = point.toString();
        System.out.println(answer);
    }
}
