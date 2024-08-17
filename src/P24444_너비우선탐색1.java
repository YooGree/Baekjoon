import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P24444_너비우선탐색1 {
    static int N;
    static int M;
    static int R;
    static ArrayList<ArrayList<Integer>> A;
    static int[] visited;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        visited = new int[N + 1];
        count = 0;
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            A.get(start).add(end);
            A.get(end).add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A.get(i), (o1, o2) -> {
                return o1 - o2;
            });
        }

        BFS(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void BFS(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = ++count;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int i = 0; i < A.get(node).size(); i++) {
                int linkNode = A.get(node).get(i);
                if (visited[linkNode] == 0) {
                    q.offer(linkNode);
                    visited[linkNode] = ++count;
                }
            }
        }
    }
}
