import java.util.Scanner;

public class SolutionGPT {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        return canWinFrom(0, leap, game, new boolean[game.length]);
    }

    private static boolean canWinFrom(int i, int leap, int[] game, boolean[] visited) {
        int n = game.length;

        // Winning conditions
        if (i >= n) return true;   // jumped/leaped outside
        if (game[i] == 1 || visited[i]) return false; // blocked or already tried

        // mark as visited
        visited[i] = true;

        // try moves
        return canWinFrom(i + leap, leap, game, visited) ||
                canWinFrom(i + 1, leap, game, visited) ||
                (i - 1 >= 0 && canWinFrom(i - 1, leap, game, visited));
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println((canWin(leap, game)) ? "YES" : "NO");
        }
        scan.close();
    }
}