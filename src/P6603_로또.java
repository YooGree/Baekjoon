import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P6603_로또 {
    static int K;
    static int[] S;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while(true) {
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            if (K == 0) break;
            S = new int[K];
            visited = new boolean[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            DFS_Backtraking(0, 0);
            System.out.println();
        }
    }

    static void DFS_Backtraking(int start, int depth) {
        if (depth == 6) {
            // 재귀함수 마치는 조건
            for (int i = 0; i < K; i++) {
                if (visited[i]) {
                    System.out.print(S[i] + " ");
                }
            }
            System.out.println();
        }

        for (int i = start; i < K; i++) {
            visited[i] = true;
            DFS_Backtraking(i + 1, depth + 1);
            visited[i] = false;
        }
    }
}
