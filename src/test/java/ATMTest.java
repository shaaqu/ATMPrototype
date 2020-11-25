import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ATMTest {

    ATM atm;

    @BeforeEach
    void setUp() {
        atm = new ATM();
    }

    @Test
    void withdrawal() {
        Map<Double, Integer> cash = new HashMap<Double, Integer>();

        cash = atm.withdrawal(140.0);

        Map<Double, Integer> actual = atm.getBalance();
        assertEquals(10, actual.get(10.0));
        assertEquals(3, actual.get(20.0));
        assertEquals(5, actual.get(50.0));
        assertEquals(4, actual.get(100.0));
        assertEquals(2, actual.get(200.0));

        assertEquals(2, cash.get(20.0));
        assertEquals(1, cash.get(100.0));

    }

    @Test
    void depositEveryBill() {
        Map<Double, Integer> cash = new HashMap<Double, Integer>();
        cash.put(10.0, 1);
        cash.put(20.0, 1);
        cash.put(50.0, 1);
        cash.put(100.0, 1);
        cash.put(200.0, 1);

        Map<Double, Integer> expected = atm.getBalance();
        expected.forEach(
                (k, v) -> expected.put(k, expected.get(k) + 1)
        );
        Map<Double, Integer> actual = atm.getBalance();

        atm.deposit(cash);

        assertEquals(expected.get(10.0), actual.get(10.0));
        assertEquals(expected.get(20.0), actual.get(20.0));
        assertEquals(expected.get(50.0), actual.get(50.0));
        assertEquals(expected.get(100.0), actual.get(100.0));
        assertEquals(expected.get(200.0), actual.get(200.0));
    }

    Map<Double, Integer> depositOneBill(double value) {
        Map<Double, Integer> cash = new HashMap<Double, Integer>();
        cash.put(value, 1);

        Map<Double, Integer> actual = atm.getBalance();
        atm.deposit(cash);

        return actual;
    }

    @Test
    void depositOneTenBill() {
        Map<Double, Integer> actual = depositOneBill(10.0);
        assertEquals(11, actual.get(10.0));
        assertEquals(5, actual.get(20.0));
        assertEquals(5, actual.get(50.0));
        assertEquals(5, actual.get(100.0));
        assertEquals(2, actual.get(200.0));
    }

    @Test
    void depositOneTwentyBill() {
        Map<Double, Integer> actual = depositOneBill(20.0);
        assertEquals(10, actual.get(10.0));
        assertEquals(6, actual.get(20.0));
        assertEquals(5, actual.get(50.0));
        assertEquals(5, actual.get(100.0));
        assertEquals(2, actual.get(200.0));
    }

    @Test
    void depositOneFiftyBill() {
        Map<Double, Integer> actual = depositOneBill(50.0);
        assertEquals(10, actual.get(10.0));
        assertEquals(5, actual.get(20.0));
        assertEquals(6, actual.get(50.0));
        assertEquals(5, actual.get(100.0));
        assertEquals(2, actual.get(200.0));
    }

    @Test
    void depositOneHundredBill() {
        Map<Double, Integer> actual = depositOneBill(100.0);
        assertEquals(10, actual.get(10.0));
        assertEquals(5, actual.get(20.0));
        assertEquals(5, actual.get(50.0));
        assertEquals(6, actual.get(100.0));
        assertEquals(2, actual.get(200.0));
    }

    @Test
    void depositOneTwoHundredBill() {
        Map<Double, Integer> actual = depositOneBill(200.0);
        assertEquals(10, actual.get(10.0));
        assertEquals(5, actual.get(20.0));
        assertEquals(5, actual.get(50.0));
        assertEquals(5, actual.get(100.0));
        assertEquals(3, actual.get(200.0));
    }

}