import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305_주유소 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 도시의 개수
        long[] dist = new long[N - 1]; // 거리
        long[] cost = new long[N]; // 비용

        // 거리 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N - 1; i++) {
            dist[i] = Long.parseLong(st.nextToken());
        }

        // 리터당 기름값 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cost[i] = Long.parseLong(st.nextToken());
        }

        long sum = 0;
        long minCost = cost[0]; // 이전 까지의 과정중 주유 최소 비용

        for (int i = 0; i < N - 1; i++) {
            // 현재 주유소가 이전 주유소의 기름값보다 쌀 경우 minCost를 갱신한다.
            if (cost[i] < minCost) {
                minCost = cost[i];
            }

            sum += (minCost * dist[i]);
        }

        System.out.println(sum);
    }
}
