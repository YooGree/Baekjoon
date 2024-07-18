import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4963_섬의개수 {
    static int W;
    static int H;
    static int[][] matrix;
    static boolean[][] visited;
    static int count;
    static int[] dx = new int[] {-1, 1, 0, -1, 1, 0, -1, -1, -1, 1, 1, 1};
    static int[] dy = new int[] {-1, -1, -1, 1, 1, 1, -1, 1, 0, -1, 1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            W = Integer.parseInt(st.nextToken()); // 가로
            H = Integer.parseInt(st.nextToken()); // 세로

            if (W == 0 && H == 0) break;

            matrix = new int[H][W];
            visited = new boolean[H][W];
            count = 0;

            for (int x = 0; x < H; x++) {
                st = new StringTokenizer(br.readLine());
                for (int y = 0; y < W; y++) {
                    matrix[x][y] = Integer.parseInt(st.nextToken());
                }
            }

            for (int x = 0; x < H; x++) {
                for (int y = 0; y < W; y++) {
                    if (!visited[x][y] && matrix[x][y] == 1) {
                        DFS(x, y);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        // 사방을 포함한 대각선 탐색
        for (int i = 0; i < 12; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            if (newX >= 0 && newY >= 0 && newX < H && newY < W && !visited[newX][newY] && matrix[newX][newY] == 1) {
                DFS(newX, newY);
            }
        }
    }
}
