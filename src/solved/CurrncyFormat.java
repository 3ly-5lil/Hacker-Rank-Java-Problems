package solved;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class CurrncyFormat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float payment = scanner.nextFloat();
        scanner.close();

        System.out.println("US: " + NumberFormat.getCurrencyInstance(Locale.US).format(payment));
        System.out.println("India: " + NumberFormat.getCurrencyInstance(new Locale("en", "IN")).format(payment));
        System.out.println("China: " + NumberFormat.getCurrencyInstance(Locale.CHINA).format(payment));
        System.out.println("France: " + NumberFormat.getCurrencyInstance(Locale.FRANCE).format(payment));
    }
}