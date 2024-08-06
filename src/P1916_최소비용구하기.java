import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1916_최소비용구하기 {
    static int N; // 도시의 수
    static int M; // 버스의 수
    static ArrayList<ArrayList<Node>> list; // 인접리스트
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리
    static boolean[] visited; // 방문 체크 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        // 단방향 인접리스트
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            // start에서 end로가는 비용cost
            list.get(start).add(new Node(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(startPos, endPos) + "\n");
    }

    public static int dijkstra(int startPos, int endPos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(startPos, 0));
        dist[startPos] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int current = currentNode.end;

            if (!visited[current]) {
                visited[current] = true;

                for (Node node : list.get(current)) {
                    if (!visited[node.end] && dist[node.end] > dist[current] + node.cost) {
                        dist[node.end] = dist[current] + node.cost;
                        queue.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[endPos];
    }

    public static class Node implements Comparable<Node> {
        int end;
        int cost;

        public Node (int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
}
