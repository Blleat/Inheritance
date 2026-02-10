import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class WorkerTest {

    Worker w1;

    @BeforeEach
    void setUp() {
        w1 = new Worker("001", "John", "Doe", "Mr.", 1990, 20.0);
    }

    @Test
    void calculateWeeklyPayRegular() {
        assertEquals(800.0, w1.calculateWeeklyPay(40), 0.01);
    }

    @Test
    void calculateWeeklyPayOvertime() {
        assertEquals(1100.0, w1.calculateWeeklyPay(50), 0.01);
    }

    @Test
    void toCSV() {
        assertEquals("001, John, Doe, Mr., 1990, 20.0", w1.toCSV());
    }

    @Test
    void toJSON() {
        assertTrue(w1.toJSON().contains("\"hourlyPayRate\":20.0"));
    }
}