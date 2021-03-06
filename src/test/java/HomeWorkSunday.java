import org.apache.commons.math3.util.Precision;
import org.junit.jupiter.api.Test;

public class HomeWorkSunday {
    @Test
    public void main() {

        String brand = "Лучшая";
        double price = 200.09;
        int millage = 999999;
        carForSell(brand, price, millage);

        double consumption100Km = 898;
        double millageBetweenCity = 100;
        gasAmount(consumption100Km, millageBetweenCity);

        String pk = "011380-11111";
        personCodeToDOB(pk);

    }

    private void carForSell(String brand, double price, int milage) {
        System.out.println("Продаем машину " + brand + " c пробегом " + milage + " за " + price + " денег");
    }

    private void gasAmount(double consumption, double millageCity) {
        double money = Precision.round(millageCity / 100 * consumption * 3.57, 2);
        System.out.println("На перелет длиной " + millageCity +
                " при среднем расходе 3.57 на 100 км составил " + money + " денег");
    }

    private void personCodeToDOB(String pk) {
        String[] partsOfPK = pk.split("-", 2);
        int firstPartPK = Integer.parseInt(partsOfPK[0]);
        int preYear = firstPartPK % 100;
        int year = 1900 + preYear;
        int preMonth = ((firstPartPK - preYear) / 100) % 100;
        String month;
        switch (preMonth) {
            case 1:
                month = "января";
                break;
            case 2:
                month = "февраля";
                break;
            case 3:
                month = "марта";
                break;
            case 4:
                month = "апреля";
                break;
            case 5:
                month = "мая";
                break;
            case 6:
                month = "июня";
                break;
            case 7:
                month = "июля";
                break;
            case 8:
                month = "августа";
                break;
            case 9:
                month = "сентября";
                break;
            case 10:
                month = "октября";
                break;
            case 11:
                month = "ноября";
                break;
            case 12:
                month = "декабря";
                break;
            default:
                month = "NA";
        }

        int day = (int) (firstPartPK / 10000);
        if ((!month.equals("NA")) && (day != 0)) {
            System.out.println("Дата вашего рождения: " + day + " " + month + " " + year + " года!");
        } else System.out.println("Дата не существует");
    }
}
