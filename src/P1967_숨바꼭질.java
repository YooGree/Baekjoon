import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1967_숨바꼭질 {
    static int N;
    static int K;
    static int[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 수빈이의 위치
        K = Integer.parseInt(st.nextToken()); // 동생의 위치
        visited = new int[100001];
        int result = BFS(N);

        System.out.println(result);
    }

    public static int BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = 1;
        while (!q.isEmpty()) {
            int node = q.poll();
            // 원하는 위치를 찾았다면 해당 시간 리턴
            if (node == K) {
                return visited[node] - 1;
            }
            // X - 1 이동
            if (node - 1 >= 0 && visited[node - 1] == 0) {
                q.offer(node - 1);
                visited[node - 1] = visited[node] + 1;
            }
            // X + 1 이동
            if (node + 1 <= 100000 && visited[node + 1] == 0) {
                q.offer(node + 1);
                visited[node + 1] = visited[node] + 1;
            }
            // x * 2 이동
            if (node * 2 <= 100000 && visited[node * 2] == 0) {
                q.offer(node * 2);
                visited[node * 2] = visited[node] + 1;
            }
        }
        return -1;
    }
}
