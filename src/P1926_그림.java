import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926_그림 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 도화지의 세로 길이
        m = Integer.parseInt(st.nextToken()); // 도화지의 가로 길이

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 0; x < m; x++) {
                int num = Integer.parseInt(st.nextToken());
                map[y][x] = num;
            }
        }

        int cnt = 0; // 그림의 갯수
        int maxExtent = 1; // 가장 큰 그림의 넓이
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {
                if (map[y][x] == 1 && !visited[y][x]) {
                    cnt++;
                    maxExtent = Math.max(maxExtent, bfs(y, x));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        if (cnt == 0) maxExtent = 0; // 그림이 한개도 없을때는 제일 큰 그림의 넓이 0으로 초기화
        sb.append(cnt + "\n" + maxExtent);

        System.out.println(sb.toString());
    }

    static int bfs(int y, int x) {
        int extent = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { y, x });

        while (!q.isEmpty()) {
            int [] axis = q.poll();
            int nowY = axis[0];
            int nowX = axis[1];

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int ny = nowY + dy[i];
                int nx = nowX + dx[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1 && !visited[ny][nx]) {
                    extent++; // 넓이를 1 늘려준다.
                    visited[ny][nx] = true;
                    q.add(new int[] { ny, nx });
                }
            }
        }

        return extent;
    }
}
