package solved;

import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        sc.close();
        /* Enter your code here. Print output to STDOUT. */

        if (isPalindrome(A)) System.out.println("Yes");
        else System.out.println("No");
    }

    private static boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - i - 1]) return false;
        }

        return true;
    }
}