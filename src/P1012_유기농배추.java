import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1012_유기농배추 {
    static int[][] matrix; // 배추밭을 담을 2차원 배열
    static boolean[][] visited; // 방문여부를 체크할 2차원 배열
    static int M; // 배추밭의 가로길이
    static int N; // 배추밭의 세로길이
    static int K; // 배추가 심어져있는 위치의 갯수
    static int count; // 지렁이의 갯수를 저장할 변수
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스만큼 반복
        StringTokenizer st;
        for (int k = 0; k < T; k++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            matrix = new int[M][N];
            visited = new boolean[M][N];
            count = 0;

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                matrix[x][y] = 1; // 1을 넣는다는건 해당 위치에 배추가 있다는 의미
            }

            for (int x = 0; x < M; x++) {
                for (int y = 0; y < N; y++) {
                    if (matrix[x][y] == 1 && !visited[x][y]) {
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
        // 사방탐색
        for (int k = 0; k < 4; k++) {
            int newX = x + dx[k];
            int newY = y + dy[k];
            if (newX >= 0 && newY >= 0 && newX < M && newY < N && !visited[newX][newY] && matrix[newX][newY] == 1) {
                DFS(newX, newY);
            }
        }

    }
}
