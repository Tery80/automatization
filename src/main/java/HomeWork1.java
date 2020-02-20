import java.util.Scanner;

public class HomeWork1 {
    public static void main(String[] args) {
//        Написать методы, что бы я мог:
//        1. подать имя и возраст человека и мне бы красиво показалось: "Привет, Дима, тебе увы аж 33"
//        2. подать количество проеханных километров и сколько топлива я залил и получить расход на сотню
//        3. подать радиус колеса и увидить длину окружности его и сколько оборотов оно сделает что бы проехать 1000км

        System.out.println("Давай начнем :) Как тебя зовут?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Сколько тебе полных лет?");
        int age = scanner.nextInt();

        nameAgeString(name, age);

        System.out.println("Продолжаем: расчет расхода топлива на 100км:");
        System.out.println("Ответь пожалуйста: Сколько топлива было израсходованно, в литрах?");
        double gasAmount = scanner.nextDouble();
        System.out.println("Какое расстояние ты проехал, в км пожалуйста?");
        double distance = scanner.nextDouble();

        gasComsumption(gasAmount, distance);

        System.out.println("Продолжаем: сколько оборотов сделает колесо с Вашим радиусом проехав 1000км:");
        System.out.println("Ответь пожалуйста: Какой радиус колеса в см?");
        double radius = scanner.nextDouble();
        wheel(radius);
        scanner.close();

    }

    private static void nameAgeString(String name, int age) {
        System.out.println("Привет, " + name + ", тебе увы аж " + age);
    }

    private static void gasComsumption(double gas, double distance) {
        double consumption = Math.round(gas / distance * 100);
        System.out.println("Расход на 100 км равен " + consumption + "л.");
    }

    private static void wheel(double radiusSm) {
        double lengthSm = Math.PI * 2 * radiusSm;
        System.out.println("Длина окружности колеса равна" + lengthSm + "в сантиметрах");
        System.out.println("За 1000 км данное колеса сделает " + Math.round(1000 * 1000 * 100 / lengthSm) + "полных оборотов");
    }
}
