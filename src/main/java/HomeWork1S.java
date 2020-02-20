import org.apache.commons.math3.util.Precision;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class HomeWork1S {
    public static void main (String[] args){

            System.out.println("Давай начнем :) Сейчас продадим твою машину");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Какая марка машины?");
            String brand = scanner.nextLine();
            System.out.println("Какой пробег?");
            int millage = scanner.nextInt();
            System.out.println("Какая цена?");
            double price = scanner.nextDouble();

            carForSell(brand,price,millage);

            System.out.println("Следующий, сколько денег ушло на топлива самалета. цена топлива 3.57 за литр");
            System.out.println("Какой расход топлива на 100км?");
            double consumption100Km = scanner.nextDouble();
            System.out.println("Какое расстояние полета, в км?");
            double millageBetweenCity = scanner.nextDouble();

            gasAmount(consumption100Km,millageBetweenCity);
            System.out.println();
            System.out.println("я угадаю твою дату рождения по персональному коду, какой у тебя код?");
            String pk = scanner.next();
            personCodeToDOB(pk);
        }

        private static void carForSell(String brand, double price, int milage){
            System.out.println("Продаем машину "+ brand + " c пробегом " + milage + " за "+ price + " денег" );
        }

        private static void gasAmount(double consumption, double millageCity){
            double money = Precision.round(millageCity/100*consumption*3.57, 2);
            System.out.println("На перелет длиной "+ millageCity +
                    " при среднем расходе 3.57 на 100 км составил " + money + " денег" );
        }
        private static void personCodeToDOB(String pk){
            String[] partsOfPK = pk.split("-", 2);
            int firstPartPK = Integer.parseInt(partsOfPK[0]);
            int preYear = firstPartPK % 100;
            int year = 1900 + preYear;
            int preMonth = ((firstPartPK - preYear)/100)%100 ;
            DateTimeFormatter df_ru = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(new Locale("ru"));
            String month = "";
            int day =(int)(firstPartPK/10000);
            LocalDate dat = LocalDate.of(year, preMonth, day);
            System.out.println(dat.format(df_ru));
        }
}

