import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9251_LCS {
    static char[] cArray1;
    static char[] cArray2;
    static Integer[][] dp;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cArray1 = br.readLine().toCharArray();
        cArray2 = br.readLine().toCharArray();

        dp = new Integer[cArray1.length][cArray2.length];

        System.out.println(LCS(cArray1.length - 1, cArray2.length - 1));
    }

    private static int LCS(int a, int b) {
        if (a < 0 || b < 0)
            return 0;

        if (dp[a][b] == null) {
            dp[a][b] = 0;
            if (cArray1[a] == cArray2[b]) {
                dp[a][b] = LCS(a - 1, b - 1) + 1;
            } else {
                dp[a][b] = Math.max(LCS(a - 1, b), LCS(a, b - 1));
            }
        }

        return dp[a][b];
    }
}
