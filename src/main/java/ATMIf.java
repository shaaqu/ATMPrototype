import java.util.Map;

public interface ATMIf {
    public Map<Double, Integer> withdrawal(double value);
    public void deposit(Map<Double, Integer> cash);
}
