import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2156_포도주시식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N + 1];
        int[] amount = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        // 1번째와 2번째잔은 최대수량이 고정
        dp[1] = amount[1];
        if (N > 1) {
            dp[2] = amount[1] + amount[2];
        }

        // Bottom Up 방식
        for (int i = 3; i <= N; i++) {
            int case1 = dp[i - 1]; // 직전 포도주잔 까지의 Max값
            int case2 = Math.max(dp[i - 2] + amount[i], dp[i - 3] + amount[i - 1] + amount[i]);
            dp[i] = Math.max(case1, case2);
        }

        System.out.println(dp[N]);

    }
}
