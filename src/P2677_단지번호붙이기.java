import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2677_단지번호붙이기 {
    static int N; // 지도의 크기
    static int[][] dangi; // 단지정보를 담은 2차원 배열
    static boolean[][] visited; // 방문여부를 담을 2차원 배열
    static List<Integer> result; // 단지별 집의 수를 저장할 리스트
    static int count; // 단지별 집의 수를 셀 변수
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dangi = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();
        count = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                int val = str.charAt(j) - '0';
                dangi[i][j] = val;
            }
        }

        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (dangi[x][y] == 1 && !visited[x][y]) {
                    DFS(x, y);
                    result.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int r : result) {
            System.out.println(r);
        }

    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;
        // 사방탐색
        for (int i = 0; i < 4; i++) {
            int newX = dx[i] + x;
            int newY = dy[i] + y;
            if (newX >= 0 && newY >= 0 && newX < N && newY < N && !visited[newX][newY] && dangi[newX][newY] == 1) {
                count++;
                DFS(newX, newY);
            }
        }
    }

}
