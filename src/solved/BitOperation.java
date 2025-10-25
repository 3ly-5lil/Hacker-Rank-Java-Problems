package solved;

import java.util.BitSet;
import java.util.Scanner;

public class BitOperation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(), m = sc.nextInt();

        BitSet b1 = new BitSet(n), b2 = new BitSet(n);

        while (m-- > 0) {
            String op = sc.next().toUpperCase();
            switch (op) {
                case "AND" -> {
                    int s1 = sc.nextInt(), s2 = sc.nextInt();
                    if (s1 == 1 && s2 == 2) b1.and(b2);
                    else if (s1 == 2 && s2 == 1) b2.and(b1);

                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                }
                case "OR" -> {
                    int s1 = sc.nextInt(), s2 = sc.nextInt();
                    if (s1 == 1 && s2 == 2) b1.or(b2);
                    else if (s1 == 2 && s2 == 1) b2.or(b1);

                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                }
                case "XOR" -> {
                    int s1 = sc.nextInt(), s2 = sc.nextInt();
                    if (s1 == 1 && s2 == 2) b1.xor(b2);
                    else if (s1 == 2 && s2 == 1) b2.xor(b1);

                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                }
                case "FLIP" -> {
                    int s = sc.nextInt(), i = sc.nextInt();
                    if (s == 1) b1.flip(i);
                    else if (s == 2) b2.flip(i);

                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                }
                case "SET" -> {
                    int s = sc.nextInt(), i = sc.nextInt();
                    if (s == 1) b1.set(i);
                    else if (s == 2) b2.set(i);

                    System.out.println(b1.cardinality() + " " + b2.cardinality());
                }
                default -> {}
            }
        }
    }
}