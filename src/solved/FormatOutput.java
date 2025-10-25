package solved;

import java.io.IOException;

public class FormatOutput {

    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        reader.close();

        String s = "cpp 65";
        String[] p = s.split(" ");

        String rs = p[0];
        int ri = Integer.parseInt(p[1]);

        System.out.printf("%-15s%03d", rs, ri);
    }
}