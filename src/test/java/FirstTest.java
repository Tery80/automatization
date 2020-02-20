import org.junit.jupiter.api.Test;

public class FirstTest {
    @Test
    public void javaBasics() {
        sumOfTwo(10, 15);
        sumOfTwo("10", "15");

    }

    private void sumOfTwo(int a, int b) {
        System.out.println("Sum is" + (a + b));

    }

    private void sumOfTwo(String a, String b) {
        sumOfTwo(Integer.parseInt(a), Integer.parseInt(b));
    }

}
