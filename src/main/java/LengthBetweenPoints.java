import java.util.Scanner;

public class LengthBetweenPoints {

   public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Coordinate X1");
        double coordinateX1 = scanner.nextInt();

        System.out.println("Enter Coordinate Y1");
        double coordinateY1 = scanner.nextInt();

        System.out.println("Enter Coordinate X2");
        double coordinateX2 = scanner.nextInt();

        System.out.println("Enter Coordinate Y2");
        double coordinateY2 = scanner.nextInt();

        double coordinateDifferenceX = (coordinateX2 - coordinateX1);
        double coordinateDifferenceY = (coordinateY2 - coordinateY1);

        double length = Math.sqrt(Math.abs(coordinateDifferenceX)+Math.abs(coordinateDifferenceY));
        System.out.print("Length = "+ length);
    }
}