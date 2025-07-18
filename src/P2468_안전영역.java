import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2468_안전영역 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상하좌우
    static int[] dy = {-1, 1, 0, 0};
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        // 지도 입력 및 최대 높이 계산
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int result = 0;

        // 비의 양(h)을 0부터 최대 높이까지 시뮬레이션
        for (int h = 0; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            int count = 0;

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < N; x++) {
                    // 아직 방문하지 않았고, 현재 높이보다 높은 곳만 탐색
                    if (!visited[y][x] && map[y][x] > h) {
                        dfs(x, y, h);
                        count++;
                    }
                }
            }

            result = Math.max(result, count); // 안전영역 최대값 갱신
        }

        System.out.println(result);
    }

    // DFS 탐색 함수
    static void dfs(int x, int y, int h) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[ny][nx] && map[ny][nx] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}
