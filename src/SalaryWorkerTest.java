import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SalaryWorkerTest {

    SalaryWorker sw1;

    @BeforeEach
    void setUp() {
        sw1 = new SalaryWorker("002", "Jane", "Smith", "Ms.", 1985, 52000.0);
    }

    @Test
    void calculateWeeklyPay() {
        assertEquals(1000.0, sw1.calculateWeeklyPay(40), 0.01);
    }

    @Test
    void calculateWeeklyPayOvertimeIgnored() {
        assertEquals(1000.0, sw1.calculateWeeklyPay(60), 0.01);
    }

    @Test
    void toCSV() {
        assertEquals("002, Jane, Smith, Ms., 1985, 52000.0", sw1.toCSV());
    }

    @Test
    void toJSON() {
        assertTrue(sw1.toJSON().contains("\"annualSalary\":52000.0"));
    }
}