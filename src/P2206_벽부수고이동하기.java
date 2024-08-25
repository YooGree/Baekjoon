import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206_벽부수고이동하기 {
    static int N; // Y축 길이
    static int M; // X축 길이
    static int[][] map; // 미로 저장 변수
    static boolean[][][] visited; // 방문 체크 배열
    static int[] dx = new int[] { 0, 0, -1, 1 };
    static int[] dy = new int[] { -1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        // [0, N, M] : 벽을 안부수고 지나가는 방문노드 경로
        // [1, N, M] : 벽을 부수고 지나가는 방문노드 경로
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        System.out.println(bfs());
        
    }

    public static int bfs() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0, false, 1));
        visited[0][0][0] = true; // 벽을 부수고 온게 아니기 때문에 지나온 칸의 개수를 1로 넣는다.

        while (!q.isEmpty()) {
            Point point = q.poll();

            if (point.x == N - 1 && point.y == M - 1) { // 도착했다면 지나간 칸의 수를 반환한다.
                return point.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int mX = point.x + dx[i];
                int mY = point.y + dy[i];

                if (mX < 0 || mX >= N || mY < 0 || mY >= M) { // 배열을 벗어난 경우는 넘어간다.
                    continue;
                }

                if (point.destroyed) { // 벽을 부순적이 있다면
                    if (map[mX][mY] == 0 && !visited[mX][mY][1]) { // 해당 지점이 벽이 아니고, 방문한적이 없다면 큐에 정보를 넣는다
                        visited[mX][mY][1] = true;
                        q.offer(new Point(mX, mY, true, point.cnt + 1));
                    }
                } else { // 벽을 부순적이 없다면
                    if (map[mX][mY] == 1) { // 해당 위치가 벽이라면
                        // 벽이라면 벽을 부수고 큐에 값을 넣는다.
                        visited[mX][mY][1] = true;
                        q.offer(new Point(mX, mY, true, point.cnt + 1));
                    } else if (!visited[mX][mY][0]) { // 벽이 아니고 방문한적이 없다면
                        visited[mX][mY][0] = true;
                        q.offer(new Point(mX, mY, false, point.cnt + 1));
                    }
                }

            }
        }

        return -1;
    }

    public static class Point {
        int x;
        int y;
        boolean destroyed;
        int cnt;
        public Point (int x, int y, boolean destroyed, int cnt) {
            this.x = x;
            this.y = y;
            this.destroyed = destroyed;
            this.cnt = cnt;
        }
    }
}
