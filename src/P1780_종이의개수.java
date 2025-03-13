import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1780_종이의개수 {
    static int MINUS = 0;
    static int ZERO = 0;
    static int PLUS = 0;
    static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        partition(0, 0, N);

        System.out.println(MINUS);
        System.out.println(ZERO);
        System.out.println(PLUS);
    }

    private static void partition(int row, int col, int size) {
        if (check(row, col, size)) {
            if (board[row][col] == -1) {
                MINUS++;
            } else if (board[row][col] == 0) {
                ZERO++;
            } else {
                PLUS++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);

        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
        partition(row + newSize, col + 2 * newSize, newSize);

        partition(row + 2 * newSize, col, newSize);
        partition(row+ 2 * newSize, col + newSize, newSize);
        partition(row+ 2 * newSize, col + 2 * newSize, newSize);

    }

    private static boolean check(int row, int col, int size) {
        int color = board[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (board[i][j] != color) {
                    return false;
                }
            }

        }
        return true;
    }
}
