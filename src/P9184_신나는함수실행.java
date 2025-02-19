import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P9184_신나는함수실행 {
    static int[][][] dp = new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(System.out));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == -1 && b == -1 && c == -1)
                return;
            long result = dynamic(a, b, c);
            System.out.println("w(" + a + ", " + b + ", " + c +") = " + result);


        }

    }
    public static int dynamic(int a, int b, int c) {

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20) {
            return dynamic(20, 20, 20);
        }

        if(dp[a][b][c] > 0)
            return dp[a][b][c];

        if (a < b && b < c) {
            dp[a][b][c] = dynamic(a, b, c - 1) + dynamic(a, b - 1, c - 1) - dynamic(a, b - 1, c);
            return dp[a][b][c];
        }
        dp[a][b][c] = dynamic(a - 1, b, c) + dynamic(a - 1, b - 1, c) +
                dynamic(a - 1, b, c - 1) - dynamic(a - 1, b - 1, c - 1);
        return dp[a][b][c];
    }
}
