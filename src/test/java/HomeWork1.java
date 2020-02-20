
import org.junit.jupiter.api.Test;

import static java.lang.System.out;

public class HomeWork1 {
    @Test
    public void main() {
//        Написать методы, что бы я мог:
//        1. подать имя и возраст человека и мне бы красиво показалось: "Привет, Дима, тебе увы аж 33"
//        2. подать количество проеханных километров и сколько топлива я залил и получить расход на сотню
//        3. подать радиус колеса и увидить длину окружности его и сколько оборотов оно сделает что бы проехать 1000км

        out.println("Давай начнем :) Как тебя зовут?");

        String name = "Maka";
        out.println("Сколько тебе полных лет?");
        int age = 5;

        nameAgeString(name, age);

        out.println("Продолжаем: расчет расхода топлива на 100км:");
        out.println("Ответь пожалуйста: Сколько топлива было израсходованно, в литрах?");
        double gasAmount = 6.8;
        out.println("Какое расстояние ты проехал, в км пожалуйста?");
        double distance = 80;

        gasComsumption(gasAmount, distance);

        out.println("Продолжаем: сколько оборотов сделает колесо с Вашим радиусом проехав 1000км:");
        out.println("Ответь пожалуйста: Какой радиус колеса в см?");
        double radius = 18;
        wheel(radius);

    }

    private void nameAgeString(String name, int age) {
        out.println("Привет, " + name + ", тебе увы аж " + age);
    }

    private void gasComsumption(double gas, double distance) {
        double consumption = Math.round(gas / distance * 100);
        out.println("Расход на 100 км равен " + consumption + "л.");
    }

    private void wheel(double radiusSm) {
        double lengthSm = Math.PI * 2 * radiusSm;
        out.println("Длина окружности колеса равна" + lengthSm + "в сантиметрах");
        out.println("За 1000 км данное колеса сделает " + Math.round(1000 * 1000 * 100 / lengthSm) + "полных оборотов");
    }
}