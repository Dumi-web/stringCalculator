import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void main() {

    }

    @Test
    void add() {
        assertEquals(0,Calculator.add(""));
        assertEquals(1,Calculator.add("1"));
        assertEquals(3,Calculator.add("1,2"));
        assertEquals(10,Calculator.add("1,2,3,4"));
        assertEquals(3,Calculator.add("//;\n1;2"));
        assertEquals(3,Calculator.add("//4\n142"));
        assertEquals(3,Calculator.add("//;\n1000,1;2"));
        assertEquals(6,Calculator.add("//***\n1***2***3"));
        assertEquals(6,Calculator.add("//[:D][%]\n1:D2%3"));
        assertEquals(6,Calculator.add("//[***][%%%]\n1***2%%%3"));
        assertEquals(6,Calculator.add("//[(-_-')][%]\n1(-_-')2%3"));
        assertEquals(7,Calculator.add("//[abc][777][:(]\n1abc27773:(1"));


    }
}