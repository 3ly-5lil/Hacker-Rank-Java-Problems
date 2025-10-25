package solved;

public class Seq {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int q = Integer.parseInt(scanner.nextLine());
        int q = 2;

        int[][] ins = new int[q][3];
//        for (int i = 0; i < q; i++) {
//            String query = scanner.nextLine();
//            String[] sq = query.split(" ");
//
//            for (int j = 0; j < 3; j++) {
//                ins[i][j] = Integer.parseInt(sq[j]);
//            }
//        }
//        scanner.close();
        ins = new int[][]{
                {0, 2, 10},
                {5, 3, 5}
        };

        for (int[] in : ins) {
            int a, b, n;

            a = in[0];
            b = in[1];
            n = in[2];

            int[] res = new int[n];

            for (int i = 0; i < res.length; i++) {
                res[i] = a + (int) (Math.pow(2,i) * b);

                for (int j = 0; j < i; j++) {
                    res[i] += (int) (Math.pow(2,j) * b);
                }

                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}