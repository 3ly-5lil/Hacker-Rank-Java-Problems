package solved;

import java.util.Scanner;

public class Tokens {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        scan.close();

        if (s.isBlank()) System.out.println(0);
        else {
            String[] tokens = s.trim().split("[^A-Za-z]+");

            System.out.println(tokens.length);
            int i = 0;
            for (String token : tokens) {
                System.out.println(++i + " " + token);
            }
        }
    }
}