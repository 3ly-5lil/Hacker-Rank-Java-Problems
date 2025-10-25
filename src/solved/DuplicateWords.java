package solved;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next(); // read full input

        // case-insensitive pattern
        String regex = "\\b(\\w+)(\\b\\W+\\b\\1\\b)*";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        Matcher m = p.matcher(input);

        while (m.find()) {
            input = input.replaceAll(m.group(0), m.group(1));
        }

        System.out.println(input);
        sc.close();

    }
}