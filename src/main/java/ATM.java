import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ATM implements ATMIf {

    private Map<Double, Integer> money = new HashMap<Double, Integer>();

    public ATM() {
        money.put(10.0, 10);
        money.put(20.0, 5);
        money.put(50.0, 5);
        money.put(100.0, 5);
        money.put(200.0, 2);
    }


    public Map<Double, Integer> withdrawal(double value) {
        Map<Double, Integer> cash = getNumOfBills(value);
        cash = cash.entrySet().stream()
                .filter(e -> e.getValue() != 0)
                .collect(Collectors.toMap(
                        e -> e.getKey(), e -> e.getValue()
                ));

        cash.forEach(
                (k, v) -> money.put(k, money.get(k) - v)
        );

        return cash;
    }

    public void deposit(Map<Double, Integer> cash) {
        cash.forEach(
                (k, v) -> money.put(k, money.get(k) + v)
        );
    }

    private Map<Double, Integer> getNumOfBills(double value) {
        Map<Double, Integer> numOfBills = new HashMap<Double, Integer>();
        numOfBills.put(200.0, (int) value / 200);
        value = value - (numOfBills.get(200.0) * 200);
        numOfBills.put(100.0, (int) value / 100);
        value = value - (numOfBills.get(100.0) * 100);
        numOfBills.put(50.0, (int) value / 50);
        value = value - (numOfBills.get(50.0) * 50);
        numOfBills.put(20.0, (int) value / 20);
        value = value - (numOfBills.get(20.0) * 20);
        numOfBills.put(10.0, (int) value / 10);
        value = value - (numOfBills.get(10.0) * 10);

        if(value != 0) new UnknownError("Something wrong with value");

        return numOfBills;
    }

    Map<Double, Integer> getBalance() {
        return money;
    }
}
