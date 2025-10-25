package solved;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

public class Balancedparentheses {

    public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Boolean> out = new ArrayList<>();
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            out.add(isBalanced(line.trim().toCharArray()));
        }

        out.forEach(System.out::println);
    }

    static boolean isBalanced(char[] chars) {
        Stack<Character> stack = new Stack<>();
        for (int i = chars.length - 1; i >= 0; i--) {
            Character current;

            try {
                current = stack.peek();
            } catch (EmptyStackException e) {
                stack.add(chars[i]);
                continue;
            }

            if (current == ']' && chars[i] == '[') stack.pop();
            else if (current == '}' && chars[i] == '{') stack.pop();
            else if (current == ')' && chars[i] == '(') stack.pop();
            else stack.add(chars[i]);
        }

        return stack.empty();
    }
}
