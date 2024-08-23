import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7569_토마토 {
    static int M; // 토마토 상자의 가로길이
    static int N; // 토마토 상자의 세로길이
    static int H; // 토마토 상자의 높이
    static int[][][] box; // 토마토의 정보를 저장할 3차원 배열
    static boolean[][][] visited; // 방문 체크 3차원 배열
    static Queue<int[]> q; // bfs를 적용하기 위한 큐
    static int[] dx = new int[] { 0, 0, -1, 1, 0, 0 };
    static int[] dy = new int[] { -1, 1, 0, 0, 0, 0};
    static int[] dh = new int[] { 0, 0, 0, 0, 1, -1};
    static int day; // 토마토가 전부 익는 날짜를 저장할 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken()); // 높이
        box = new int[H][N][M];
        visited = new boolean[H][N][M];
        q = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int status = Integer.parseInt(st.nextToken());
                    if (status == 1) {
                        // 토마토가 이미 익어있는 상태라면
                        q.offer(new int[] { i, j, k });
                    }
                    box[i][j][k] = status;
                }
            }
        }

        bfs();

        // 하나라도 익지 않은 토마토가 있다면,
        if (checkTomato()) {
            if (day == 0) {
                // 이미 토마토가 전부 익어있는 상태라면
                System.out.println(0);
            } else {
                System.out.println(--day);
            }
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] tomato = q.poll();
            int x = tomato[2];
            int y = tomato[1];
            int h = tomato[0];
             visited[h][y][x] = true;
            // 상, 하, 좌, 우, 위, 아래 6방향 탐색
            for (int i = 0; i < 6; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];
                int mH = h + dh[i];
                // 탐색하는 좌표가 범위를 벗어나지 않았고,
                if (mX >= 0 && mY >= 0 && mH >= 0 && mX < M && mY < N && mH < H) {
                    // 방문하지 않았고,
                    if (!visited[mH][mY][mX]) {
                        // 토마토가 익지 않았다면
                        if (box[mH][mY][mX] == 0) {
                            box[mH][mY][mX] = day = box[h][y][x] + 1;
                            visited[mH][mY][mX] = true;
                            q.offer(new int[] { mH, mY, mX });
                        }
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (box[i][j][k] == 0) {
                        // 한개라도 익지 않은 토마토가 있다면
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
