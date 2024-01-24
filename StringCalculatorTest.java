import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringCalculatorTest {
    private StringCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
    }

    @Test
    void addTest1_1() {
        int add = calculator.add("");
        Assertions.assertEquals(0, add);
    }

    @Test
    void addTest1_2() {
        int add = calculator.add("1");
        Assertions.assertEquals(1, add);
    }

    @Test
    void addTest1_3() {
        int add = calculator.add("1,2");
        Assertions.assertEquals(3, add);
    }

    @Test
    void addTest2() {
        int add = calculator.add("1,2,3,4");
        Assertions.assertEquals(10, add);
    }

}

