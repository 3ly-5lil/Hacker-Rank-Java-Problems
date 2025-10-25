package solved;

import java.util.*;

public class DequeUniques {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.addLast(num);
            map.put(num, map.getOrDefault(num, 0) + 1);

            if (deque.size() >= m) {
                max = Math.max(map.size(), max);
                int first = deque.removeFirst();

                if (map.get(first) == 1) map.remove(first);
                else map.put(first, map.get(first) - 1);
            }
        }

        System.out.println(max);
    }
}



