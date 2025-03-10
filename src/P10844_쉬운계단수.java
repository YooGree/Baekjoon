import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10844_쉬운계단수 {
    static long dp[][];
    static long mod = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new long[N + 1][10];
        for (int i = 1; i < 10; i++) {
            // 첫번째 자릿수의 자릿값에 올 수 있는 경우의 수는 무조건 1
            dp[1][i] = 1;
        }

        for (int i = 2; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    // 자릿값이 0인 경우는 이전 자릿값이 1만 올 수 있음 (ex : 10)
                    dp[i][j] = dp[i-1][1] % mod;
                } else if (j == 9) {
                    // 자릿값이 9인 경우에는 이전 자릿값이 8만 올 수 있음 (ex : 89)
                    dp[i][j] = dp[i-1][8] % mod;
                } else {
                    // 자릿값이 2~8인 경우에는 +-1을 한 값이 올 수 있음 (ex : 12, 32)
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < 10; i++) {
            result += dp[N][i];
        }

        System.out.println(result % mod);
    }
}
