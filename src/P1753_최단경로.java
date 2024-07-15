import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P1753_최단경로 {
    static ArrayList<다익스트라.Node>[] graph; // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
    static boolean[] visited; // 노드를 방문한적이 있는치 체크하는 배열
    static int[] dist; // 최단거리를 계속 업데이트할 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int E = Integer.parseInt(st.nextToken()); // 간선의 갯수
        int K = Integer.parseInt(br.readLine()); // 출발점

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        dist = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE; // 초기에는 최단거리를 최대값으로 초기화
        }

        for (int i = 0; i < E; i++) {
            // U -> V로 가는 가중치 W가 주어진다.
            st = new StringTokenizer(br.readLine());
            int inputU = Integer.parseInt(st.nextToken());
            int inputV = Integer.parseInt(st.nextToken());
            int inputW = Integer.parseInt(st.nextToken());

            graph[inputU].add(new 다익스트라.Node(inputV, inputW));
        }

        // 다익스트라 알고리즘
        dijkstra(K);

        // 최단거리 출력
        for (int i = 1; i <= V; i++) {
            System.out.println(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]);
        }
    }

    static void dijkstra(int startNode) {
        // 우선순위 큐를 사용하되, 가중치를 기준으로 오름차순한다.
        //PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        PriorityQueue<다익스트라.Node> pq = new PriorityQueue<>();

        // 시작노드에 대해 초기화한다.
        pq.offer(new 다익스트라.Node(startNode, 0));
        dist[startNode] = 0;

        while (!pq.isEmpty()) {
            // 현재 방문한 노드를 꺼낸 후 방문처리를 한다.
            다익스트라.Node cNode = pq.poll();
            if (!visited[cNode.V]) {
                visited[cNode.V] = true;
            }
            // 현재 방문한 노드의 인접노드를 탐색한다.
            for (다익스트라.Node linkNode : graph[cNode.V]) {
                // 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을경우 dist 배열 업데이트 후 큐에 넣어준다.
                if (!visited[linkNode.V] && dist[linkNode.V] > cNode.cost + linkNode.cost) {
                    dist[linkNode.V] = cNode.cost + linkNode.cost;
                    pq.offer(new 다익스트라.Node(linkNode.V, dist[linkNode.V]));
                }
            }
        }
    }

    static class Node implements Comparable<다익스트라.Node>{
        int V; // 노드
        int cost; // 가중치

        public Node (int V, int cost) {
            this.V = V;
            this.cost = cost;
        }

        @Override
        public int compareTo(다익스트라.Node o) {
            return this.cost - o.cost;
        }
    }
}
