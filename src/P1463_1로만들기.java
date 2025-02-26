import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1463_1로만들기 {

    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        dp[0] = dp[1] = 0;

        System.out.println(recur(N));
    }

    private static int recur(int N) {
        if (dp[N] == null) {
            if (N % 6 == 0) {
                // 2와 3으로 나누어 떨어지는 경우
                dp[N] = Math.min(recur(N - 1), Math.min(recur(N / 3), recur(N / 2))) + 1;
            } else if (N % 3 == 0) {
                // 3으로만 나누어 떨어지는 경우
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            } else if (N % 2 == 0) {
                // 2로만 나누어 떨어지는 경우
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            } else {
                // 2와 3으로 나누어 떨어지지 않는 경우
                dp[N] = recur(N - 1) + 1;
            }
        }
        return dp[N];
    }
}
