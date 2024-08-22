import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7576_토마토 {
    static int M; // 토마토 상자의 가로 길이
    static int N; // 토마토 상자의 세로 길이
    static int[][] box; // 토마토 상자 2차원 배열
    static boolean[][] visited; // 방문 체크 2차원 배열
    static Queue<int[]> q = new LinkedList<>(); // 익은 토마토를 넣을 큐 (BFS 활용)
    static int day; // 토마토가 모두 익기위한 날짜
    static int[] dx = new int[] {0, 0, -1, 1}; // 사방탐색을 위한 x 좌표 배열
    static int[] dy = new int[] {-1, 1, 0, 0}; // 사방탐색을 위한 y 좌표 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tomatoStatus = Integer.parseInt(st.nextToken());
                box[i][j] = tomatoStatus;
                // 익은 토마토라면 먼저 큐에 넣는다.
                if (tomatoStatus == 1) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        bfs();

        if (checkTomato()) {
            if (day == 0) {
                System.out.println(day);
            } else {
                System.out.println(--day);
            }
        } else {
            System.out.println(-1);
        }

//        int ans = 0;
//        if (day == 0) {
//            System.out.println(day);
//        } else {
//            Loop1:
//            for (int i = 0; i < N; i++) {
//                Loop2:
//                for (int j = 0; j < M; j++) {
//                    if (box[i][j] == 0) {
//                        ans = -1;
//                        break Loop1;
//                    }
//                }
//            }
//            if (ans != -1) {
//                ans = --day;
//            }
//
//            System.out.println(ans);
//        }
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            int[] xy = q.poll();
            int x = xy[1];
            int y = xy[0];
            visited[y][x] = true;
            // 사방 탐색 (상, 하, 좌, 우)
            for (int i = 0; i < 4; i++) {
                int mX = x + dx[i];
                int mY = y + dy[i];
                if (mX >= 0 && mY >= 0 && mX < M && mY < N && box[mY][mX] == 0) {
                    if (!visited[mY][mX]) {
                        visited[mY][mX] = true;
                        box[mY][mX] = day = box[y][x] + 1;
                        q.offer(new int[] { mY, mX });
                    }
                }
            }
        }
    }

    public static boolean checkTomato() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 0) {
                    // 덜 익은 토마토가 있다면
                    return false;
                }
            }
        }
        return true;
    }
}
