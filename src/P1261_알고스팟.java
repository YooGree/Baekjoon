import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1261_알고스팟 {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int count; // 벽을 부순 개수

        Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Point o) {
            return this.count - o.count; // 벽을 부순 개수 오름차순 정렬 (작을수록 우선순위 높음)
        }
    }
    static int N, M;
    static int[][] map;
    static int[] dx = { 0, 0, -1, 1 };
    static int[] dy = { -1, 1, 0, 0 };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 도착지 행
        N = Integer.parseInt(st.nextToken()); // 도착지 열
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        int answer = bfs(0, 0);
        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int x, int y) {
        PriorityQueue<Point> pq = new PriorityQueue<>();

        pq.offer(new Point(x, y, 0));
        boolean[][] visited = new boolean[N][M];
        visited[x][y] = true;

        while (!pq.isEmpty()) {
            Point p = pq.poll();

            // 도착점에 도착했다면 종료
            if (p.x == N - 1 && p.y == M - 1) {
                return p.count;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];

                if (nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) {
                    continue;
                }

                // 방인 경우
                if (!visited[nx][ny] && map[nx][ny] == 0) {
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, p.count));
                }
                
                // 벽인 경우
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    pq.offer(new Point(nx, ny, p.count + 1));
                }
            }
        }
        return 0;
    }
}
