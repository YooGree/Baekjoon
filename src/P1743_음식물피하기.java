import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1743_음식물피하기 {
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static boolean[][] visited;
    static Queue<Node> que;
    static int gSize;
    static int fSize;
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 음식물쓰레기 갯수(정점의 갯수)
        map = new int[N][M];
        visited = new boolean[N][M];
        que = new LinkedList<>();
        gSize = 0;
        fSize = 0;

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            map[h][w] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    BFS(i, j);
                    if (fSize < gSize) {
                        fSize = gSize;
                    }
                }
            }
        }

        System.out.println(fSize);
    }

    private static void BFS(int y, int x) {
        visited[y][x] = true;
        que.offer(new Node(y, x));
        gSize = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int newY = node.y + dy[i];
                int newX = node.x + dx[i];
                if (newY >= 0 && newX >= 0 && newY < N && newX < M) {
                    if (!visited[newY][newX] && map[newY][newX] == 1) {
                        visited[newY][newX] = true;
                        que.offer(new Node(newY, newX));
                        gSize++;
                    }
                }
            }
        }
    }

    public static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

}
