package ua.ithlillel.dnipro.Cherednychenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;

public class Main {

    private static final int POINTQUANTITY = 10;
    private static Point[] pointsCoordinateArray = new Point[POINTQUANTITY];
    private static Circle circle;

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("Program for checking if chosen points are situated inside the  circle\n");
        System.out.println("Please enter the coordinates of " + POINTQUANTITY + " points. " +
                "\nCoordinates of each point should be separated with a space. " +
                "\nPoints should be entered each from new line" +
                "\nExample is below:" +
                "\nX Y" +
                "\nX Y" +
                "\n..." +
                "\nX Y");

        getPointsCoordinates();
        System.out.println("Please enter the coordinates of circle center separated with a space");
        getCircleCenterPoint();

        System.out.println("Please enter the radius of circle");
        getCircleCenterRadius();

        showPointsSituatedInCircle(pointsCoordinateArray, circle);

    }

    private static void getPointsCoordinates() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String stringInputLines = "";
        for (int i = 0; i < POINTQUANTITY; i++) {
            stringInputLines = stringInputLines + br.readLine()+" ";
        }

        fillPointArray(createStringInputArray(stringInputLines));
    }

    private static String [] createStringInputArray(String stringInputLines) throws IOException {
        String[] stringArray = new String[POINTQUANTITY * 2];
        try {
            stringArray = stringInputLines.split(" ", POINTQUANTITY * 2);
        } catch (Exception e) {
            new InputPointException().message();
            getPointsCoordinates();
        }
        return stringArray;
    }


    private static void fillPointArray(String [] stringArray) throws IOException {


        int pointArrayIndex = 0;

        for (int i = 0; i < stringArray.length; i = i + 2) {

            try {
                Point p = new Point(Double.parseDouble(stringArray[i]), Double.parseDouble(stringArray[i + 1]));
                pointsCoordinateArray[pointArrayIndex] = p;
            } catch (Exception e) {
                new InputPointException().message();
                getPointsCoordinates();
            }
            pointArrayIndex = pointArrayIndex + 1;

        }


    }

    private static void getCircleCenterPoint() throws IOException {
        String x = new BufferedReader(new InputStreamReader(System.in)).readLine();
        String[] stringArray = x.split(" ");
        if (stringArray.length != (2)) {
            new InputPointException().message();
            getCircleCenterPoint();
        }

        try {
            circle = new Circle(new Point(Double.parseDouble(stringArray[0]), Double.parseDouble(stringArray[1])));
        } catch (Exception e) {
            new InputPointException().message();
            getCircleCenterPoint();
        }

    }

    private static void getCircleCenterRadius(){
        try {
            circle.setRadius(Double.parseDouble(new BufferedReader(new InputStreamReader(System.in)).readLine()));
        }
        catch (Exception e)
        {
            new InputPointException().message();
            getCircleCenterRadius();
        }
    }


    private static void showPointsSituatedInCircle(Point[] array, Circle circle) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (Point.getDistanceBetweenPoints(array[i], circle.getCenter()) <= circle.getRadius()) {
                System.out.println("Point " + (i + 1) + " with coordinates [" + array[i].getX() + "; " + array[i].getY() + "] is inside the circle.");
                check=true;
            }
        }
        if (!check){
            System.out.println("There are no points inside the circle");
        }
    }

}
