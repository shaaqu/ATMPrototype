import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ATMIf atm = new ATM();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Aby wyplacic pieniadze wcisnij 1.");
        System.out.println("Aby wplacic pieniadze wcisnij 2.");
        int action = scanner.nextInt();

        switch (action){
            case 1:
                System.out.println("Podaj wartosc");
                int value = scanner.nextInt();
                System.out.println(atm.withdrawal(value));
                break;
            case 2:
                Map<Double, Integer> cash = new HashMap<Double, Integer>();

                System.out.println("Podaj ilosc 10:");
                int amount = scanner.nextInt();
                cash.put(10.0, amount);

                System.out.println("Podaj ilosc 20:");
                amount = scanner.nextInt();
                cash.put(20.0, amount);

                System.out.println("Podaj ilosc 50:");
                amount = scanner.nextInt();
                cash.put(50.0, amount);

                System.out.println("Podaj ilosc 100:");
                amount = scanner.nextInt();
                cash.put(100.0, amount);

                System.out.println("Podaj ilosc 200:");
                amount = scanner.nextInt();
                cash.put(200.0, amount);

                atm.deposit(cash);
                break;
        }
    }

}
