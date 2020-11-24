package ua.ithlillel.dnipro.Cherednychenko;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    private static final int POINTQUANTITY = 3;

    public static void main(String[] args) {
        // write your code here

        System.out.println("Program for checking if chosen points are situated inside the  circle\n");


        System.out.println("Please enter the coordinates of " + POINTQUANTITY + " points.");
        Point[] pointsCoordinateArray = getPointsCoordinates();


        System.out.println("Please enter the coordinates of circle center separated with a space");
        Circle circle = getCircle();


        showPointsSituatedInCircle(pointsCoordinateArray, circle);

    }

    private static Point [] getPointsCoordinates() {
        Point [] pointArray = new Point[POINTQUANTITY];
        int arrayIndex = 0;
        Scanner sc = new Scanner(System.in);
        try {
            for (int i = 0; i < POINTQUANTITY * 2; i = i + 2) {
                pointArray[arrayIndex] = new Point(sc.nextDouble(), sc.nextDouble());
                arrayIndex++;
            }

        } catch (Exception e) {
            new InputPointException().message();
          getPointsCoordinates();
        }
        return pointArray;
    }

    private static Circle getCircle (){
        Scanner sc = new Scanner(System.in);
        Circle circle=new Circle();
        try  {
            circle = new Circle(new Point(sc.nextDouble(), sc.nextDouble()), sc.nextDouble());
           if (circle.getRadius()==0){throw new InputPointException ();}
        }
        catch (InputPointException e){
            new InputPointException().message();
            getCircle();
        }
        return circle;
    }

    private static void showPointsSituatedInCircle(Point[] array, Circle circle) {
        boolean check = false;
        for (int i = 0; i < array.length; i++) {
            if (circle.getDistanceBetweenPoints(array[i]) <= circle.getRadius()) {
                System.out.println("Point " + (i + 1) + " with coordinates [" + array[i].getX() + "; " + array[i].getY() + "] is inside the circle.");
                check = true;
            }
        }
        if (!check) {
            System.out.println("There are no points inside the circle");
        }
    }

}
