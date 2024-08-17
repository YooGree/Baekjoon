import java.util.*;

public class P24445_너비우선탐색2 {
    static int N;
    static int M;
    static int R;
    static ArrayList<ArrayList<Integer>> A;
    static int[] visited;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        A = new ArrayList<>();
        visited = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }
        count = 0;

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            A.get(start).add(end);
            A.get(end).add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(A.get(i), (o1, o2) -> {
                return o2 - o1;
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
