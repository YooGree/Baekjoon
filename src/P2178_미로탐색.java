import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class P2178_미로탐색 {
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static int N, M;
    static boolean[][] visited;
    static int[][] miro;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); // 행
        M = sc.nextInt(); // 열
        sc.nextLine();

        visited = new boolean[N][M];
        miro = new int[N][M];

        for (int i = 0; i < miro.length; i++) {
            String row = sc.nextLine();
            char[] rowCharArr = row.toCharArray();

            for (int j = 0; j < rowCharArr.length; j++) {
                miro[i][j] = rowCharArr[j] - 48;
            }
        }
        BFS(0,0);
        System.out.println(miro[N-1][M-1]);
    }

    private static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});

        while (!queue.isEmpty()) {
            int[] nowAxis = queue.poll();
            visited[i][j] = true;

            for (int k = 0; k < 4; k++) {
                int x = nowAxis[0] + dx[k];
                int y = nowAxis[1] + dy[k];
                if (x >= 0 && y >= 0 && x < N && y < M) {
                    if (miro[x][y] != 0 && !visited[x][y]) {
                        visited[x][y] = true;
                        miro[x][y] = miro[nowAxis[0]][nowAxis[1]] + 1;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
        }
    }
}
