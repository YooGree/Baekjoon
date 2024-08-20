import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562_나이트의이동 {
    static int I;
    static int[][] miro;
    static boolean[][] visited;
    static int sX, sY;
    static int eX, eY;
    static int[] dx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] dy = {-1, 1, -2, 2, -2, 2, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 총 테스트 케이스

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            I = Integer.parseInt(st.nextToken()); // 체스판 한 변의 길이
            miro = new int[I][I];
            visited = new boolean[I][I];
            st = new StringTokenizer(br.readLine());
            sX = Integer.parseInt(st.nextToken()); // 시작 x 좌표
            sY = Integer.parseInt(st.nextToken()); // 시작 y 좌표
            st = new StringTokenizer(br.readLine());
            eX = Integer.parseInt(st.nextToken()); // 도착 x 좌표
            eY = Integer.parseInt(st.nextToken()); // 도착 y 좌표

            BFS();

            System.out.println(miro[eX][eY]);
        }
    }

    public static void BFS() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sX, sY});
        visited[sX][sY] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nX = now[0];
            int nY = now[1];

            for (int i = 0; i < 8; i++) {
                int mX = nX + dx[i];
                int mY = nY + dy[i];

                if (mX >= 0 && mY >= 0 && mX < I && mY < I) {
                    if (!visited[mX][mY]) {
                        q.offer(new int[] {mX, mY});
                        visited[mX][mY] = true;
                        miro[mX][mY] = miro[nX][nY] + 1;
                    }
                }
            }

        }

    }
}
