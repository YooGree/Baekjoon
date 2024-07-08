import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1707_이분그래프 {
    static ArrayList<Integer>[] A;
    static int[] check;
    static boolean[] visited;
    static boolean IsEven;
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bfr.readLine());
        for (int i = 0; i < testCase; i++) {
            String[] s = bfr.readLine().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            A = new ArrayList[V + 1];
            visited = new boolean[V + 1];
            check = new int[V + 1];
            IsEven = true;

            for (int j = 1; j < V + 1; j++) {
                A[j] = new ArrayList<Integer>();
            }
            
            // 엣지 데이터 저장
            for (int j = 0; j < E; j++) {
                s = bfr.readLine().split(" ");
                int start = Integer.parseInt(s[0]);
                int end = Integer.parseInt(s[1]);
                A[start].add(end);
                A[end].add(start);
            }

            // 모든 노드에서 DFS 실행
            for (int j = 1; j <= V; j++) {
                if (IsEven) {
                    DFS(j);
                } else {
                    break;
                }
            }

            if (IsEven) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private static void DFS(int startNode) {
        visited[startNode] = true;
        // 인접 리스트로 받았기 때문에 start에서 연결된 모든 노드를 탐색한다.
        for (int i : A[startNode]) {
            if (!visited[i]) {
                // 직전에 있는 노드와 다른 집합으로 분류해준다.
                check[i] = (check[startNode] + 1) % 2;
                DFS(i);
            } else {
                if (check[i] == check[startNode]) {
                    IsEven = false;
                }
            }

        }
    }
}
