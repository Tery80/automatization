import java.util.*;
import java.lang.*;

public class TwoPointsOnEarth {
    public static void main(String[] args) {
        // using https://en.wikipedia.org/wiki/Great-circle_distance formula
        //PI - pi number

        int earthRad = 6371; // radius in km

        double coordinateX1 = 40.71;
        double coordinateY1 = 74.01;
        double coordinateX2 = 64.28;
        double coordinateY2 = 100.22;

        // recalculate in radians
        double radLatitude1 = Math.toRadians(coordinateX1);
        double radLongitude1 = Math.toRadians(coordinateY1);
        double radLatitude2 = Math.toRadians(coordinateX2);
        double radLongitude2 = Math.toRadians(coordinateY2);

        // sin and cos of longitude and latitude and deltas of that

        // using Haversine formula

        double variable = Math.pow(Math.sin((radLatitude2-radLatitude1)/2), 2)
                + Math.cos(radLatitude1) * Math.cos(radLatitude2) *
                Math.pow(Math.sin((radLongitude2-radLongitude1)/2), 2);

        // great circle distance in radians
        double angle = 2 * Math.asin(Math.min(1, Math.sqrt(variable)));
        double greatCircleDistance = angle * earthRad;

        System.out.println("distance by Harvesin formula = " + Math.round(greatCircleDistance) + "km");
    }
}
