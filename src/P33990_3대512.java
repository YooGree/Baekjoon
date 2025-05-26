import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P33990_3대512 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int ans = -1;

        boolean isFirst = true;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                int num = Integer.parseInt(st.nextToken());
                sum += num;
            }
            if (sum < 512) continue;
            if (isFirst) {
                isFirst = false;
                ans = sum;
                continue;
            }
            if (sum < ans) ans = sum;
        }
        System.out.println(ans);
    }
}
