import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11050_이항계수1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(BC(N, K));
    }

    static int BC(int n, int k) {
        // 2번 성질
        if (n == k || k == 0) {
            return 1;
        }

        // 1번 성질
        return BC(n - 1, k - 1) + BC(n - 1, k);
    }

}
