import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11404_플로이드 {
    static int n; // 도시의 개수
    static int m; // 버스의 개수
    static int[][] a; // 모든 도시간 비용을 저장할 2차원 배열
    static int INF = 100000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()) + 1;
        m = Integer.parseInt(br.readLine());
        a = new int[n][n];

        // 초기화
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                a[i][j] = INF;
                if (i == j) a[i][j] = 0;
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            a[start][end] = Math.min(a[start][end], cost);
        }

        floydWarshall();

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (a[i][j] == INF) a[i][j] = 0; // 갈 수 없는곳은 0으로 초기화
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    static public void floydWarshall() {
        for (int k = 1; k < n; k++) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    if (a[i][j] > a[i][k] + a[k][j]) {
                        a[i][j] = a[i][k] + a[k][j];
                    }
                }
            }
        }

    }
}
