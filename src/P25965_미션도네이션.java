import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25965_미션도네이션 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int M = Integer.parseInt(br.readLine());

            long total = 0L;

            long[] krr = new long[M];
            long[] drr = new long[M];
            long[] arr = new long[M];

            for (int j = 0; j < M; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                krr[j] = Long.parseLong(st.nextToken());
                drr[j] = Long.parseLong(st.nextToken());
                arr[j] = Long.parseLong(st.nextToken());
            }

            StringTokenizer st = new StringTokenizer(br.readLine());

            long k = Long.parseLong(st.nextToken());
            long d = Long.parseLong(st.nextToken());
            long a = Long.parseLong(st.nextToken());

            for (int j = 0; j < M; j++) {
                long sum = (krr[j] * k) - (drr[j] * d) + (arr[j] * a);
                if (sum > 0) {
                    total += sum;
                }
            }

            System.out.println(total);
        }
    }
}
