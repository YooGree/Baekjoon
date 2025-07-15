import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P1987_알파벳 {
    static int R, C;
    static char[][] board;
    static int max = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // 방문한 알파벳을 저장하는 HashSet (경로마다 따로 써야 하므로 인자로 전달)
        HashSet<Character> visited = new HashSet<>();
        visited.add(board[0][0]);
        dfs(0, 0, 1, visited); // (y, x, 현재 경로 길이, 방문한 알파벳들)

        System.out.println(max);
    }

    private static void dfs(int y, int x, int depth, HashSet<Character> visited) {
        max = Math.max(max, depth);

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                char nextChar = board[ny][nx];

                if (!visited.contains(nextChar)) {
                    visited.add(nextChar); // 경로에 추가
                    dfs(ny, nx, depth + 1, visited); // 재귀 호출
                    visited.remove(nextChar); // 백트래킹 (원복)
                }
            }
        }
    }
}
