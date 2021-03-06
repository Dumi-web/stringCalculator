import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        assertEquals(0,stringCalculator.add(""));
        assertEquals(1,stringCalculator.add("1"));
        assertEquals(3,stringCalculator.add("1,2"));
        assertEquals(10,stringCalculator.add("1,2,3,4"));
        assertEquals(3,stringCalculator.add("//;\n1;2"));
        assertEquals(3,stringCalculator.add("//4\n142"));
        assertEquals(3,stringCalculator.add("//;\n1000,1;2"));
        assertEquals(6,stringCalculator.add("//***\n1***2***3"));
        assertEquals(6,stringCalculator.add("//[:D][%]\n1:D2%3"));
        assertEquals(6,stringCalculator.add("//[***][%%%]\n1***2%%%3"));
        assertEquals(6,stringCalculator.add("//[(-_-')][%]\n1(-_-')2%3"));
        assertEquals(7,stringCalculator.add("//[abc][777][:(]\n1abc27773:(1"));

    }
    @Test
    void Exceptions(){
        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                stringCalculator output = new stringCalculator();
                output.add("1,2,3//;\n1000,1;2");
            }
        });

    }
    @Test
    void Exception(){
        assertThrows(IllegalArgumentException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                stringCalculator outcome = new stringCalculator();
                outcome.add("-1,2,-3,4");
            }
        });
    }
}