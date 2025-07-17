import java.io.*;
import java.util.*;

public class P4179_불 {
    static int[] dy = { -1, 1, 0, 0 };
    static int[] dx = { 0, 0, -1, 1 };
    static int R, C; // 미로의 행, 열의 수
    static char[][] miro; // 미로  2차원 배열
    static int[][] jVisited; // 지훈이가 방문한 곳
    static int[][] fVisited; // 불이 방문한 곳

    static class Point { // 좌표와 시간을 관리하는 클래스
        int y, x, time;

        public Point(int y, int x, int time) {
            this.y = y;
            this.x = x;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        miro = new char[R][C];
        jVisited = new int[R][C];
        fVisited = new int[R][C];

        Queue<Point> fireQueue = new LinkedList<>();
        Queue<Point> jihunQueue = new LinkedList<>();

        // 불과 지훈이 좌표 찾기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                miro[i][j] = line.charAt(j);
                jVisited[i][j] = -1;
                fVisited[i][j] = -1;

                if (miro[i][j] == 'F') {
                    fireQueue.offer(new Point(i, j, 0));
                    fVisited[i][j] = 0;
                }
                if (miro[i][j] == 'J') {
                    jihunQueue.offer(new Point(i, j, 0));
                    jVisited[i][j] = 0;
                }
            }
        }

        // 먼저 불 BFS -> 지훈 BFS
        fireBfs(fireQueue);
        jihoonBfs(jihunQueue);
    }

    private static void fireBfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (miro[ny][nx] == '#' || fVisited[ny][nx] != -1) continue;

                fVisited[ny][nx] = now.time + 1;
                q.offer(new Point(ny, nx, now.time + 1));
            }
        }
    }

    private static void jihoonBfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point now = q.poll();

            // 탈출 조건: 가장자리 도달 시
            if (now.y == 0 || now.y == R - 1 || now.x == 0 || now.x == C - 1) {
                System.out.println(now.time + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];

                if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
                if (miro[ny][nx] == '#' || jVisited[ny][nx] != -1) continue;

                // 불보다 먼저 도착해야만 이동 가능
                if (fVisited[ny][nx] != -1 && fVisited[ny][nx] <= now.time + 1) continue;

                jVisited[ny][nx] = now.time + 1;
                q.offer(new Point(ny, nx, now.time + 1));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}
