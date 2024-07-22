import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1303_전쟁전투 {
    static int N;
    static int M;
    static int WTeamCount;
    static int BTeamCount;
    static int count;
    static char[][] matrix;
    static boolean[][] visited;
    static Queue<Node> que;
    static int[] dx = new int[] {0, 0, -1, 1};
    static int[] dy = new int[] {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로길이
        M = Integer.parseInt(st.nextToken()); // 세로길이
        WTeamCount = 0;
        BTeamCount = 0;
        count = 0;
        matrix = new char[M][N];
        visited = new boolean[M][N];
        que = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for (int j = 0; j < N; j++) {
                char strChar = str.charAt(j);
                matrix[i][j] = strChar;
            }
        }

        // BFS
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (matrix[i][j] == 'W') {
                        int num = BFS(i, j, 'W');
                        WTeamCount += num * num;
                    } else {
                        int num = BFS(i, j, 'B');
                        BTeamCount += num * num;
                    }
                }
            }
        }

        System.out.println(WTeamCount + " " + BTeamCount);
    }

    static int BFS (int y, int x, char ch) {
        que.offer(new Node(y, x));
        visited[y][x] = true;
        count = 1;
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int newY = node.y + dy[i];
                int newX = node.x + dx[i];
                if (newX >= 0 && newY >= 0 && newY < M && newX < N) {
                    if (!visited[newY][newX] && matrix[newY][newX] == ch) {
                        que.offer(new Node(newY, newX));
                        visited[newY][newX] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static class Node {
        int y;
        int x;
        public Node(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
