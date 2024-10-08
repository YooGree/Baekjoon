import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 다익스트라 {
    static ArrayList<Node>[] graph; // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 리스트
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

            graph[inputU].add(new Node(inputV, inputW));
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
        PriorityQueue<Node> pq = new PriorityQueue<>();

        // 시작노드에 대해 초기화한다.
        pq.offer(new Node(startNode, 0));
        dist[startNode] = 0;

        while (!pq.isEmpty()) {
            // 현재 방문한 노드를 꺼낸 후 방문처리를 한다.
            Node cNode = pq.poll();
            if (!visited[cNode.V]) {
                visited[cNode.V] = true;
            }
            // 현재 방문한 노드의 인접노드를 탐색한다.
            for (Node linkNode : graph[cNode.V]) {
                // 방문하지 않았고, 현재 노드를 거쳐서 다른 노드로 이동하는 거리가 더 짧을경우 dist 배열 업데이트 후 큐에 넣어준다.
                if (!visited[linkNode.V] && dist[linkNode.V] > cNode.cost + linkNode.cost) {
                    dist[linkNode.V] = cNode.cost + linkNode.cost;
                    pq.offer(new Node(linkNode.V, dist[linkNode.V]));
                }
            }
        }
    }

    static class Node implements Comparable<Node>{
        int V; // 노드
        int cost; // 가중치

        public Node (int V, int cost) {
            this.V = V;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }
}
/* 
* 문제
방향그래프가 주어지면 주어진 시작점에서 다른 모든 정점으로의 최단 경로를 구하는 프로그램을 작성하시오. 단, 모든 간선의 가중치는 10 이하의 자연수이다.

* 입력
첫째 줄에 정점의 개수 V와 간선의 개수 E가 주어진다. (1 ≤ V ≤ 20,000, 1 ≤ E ≤ 300,000) 모든 정점에는 1부터 V까지 번호가 매겨져 있다고 가정한다.
둘째 줄에는 시작 정점의 번호 K(1 ≤ K ≤ V)가 주어진다. 셋째 줄부터 E개의 줄에 걸쳐 각 간선을 나타내는 세 개의 정수 (u, v, w)가 순서대로 주어진다.
이는 u에서 v로 가는 가중치 w인 간선이 존재한다는 뜻이다. u와 v는 서로 다르며 w는 10 이하의 자연수이다.
서로 다른 두 정점 사이에 여러 개의 간선이 존재할 수도 있음에 유의한다.

* 출력
첫째 줄부터 V개의 줄에 걸쳐, i번째 줄에 i번 정점으로의 최단 경로의 경로값을 출력한다. 시작점 자신은 0으로 출력하고, 경로가 존재하지 않는 경우에는 INF를 출력하면 된다.

* 예제입력
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

* 예제출력
0
2
3
7
INF
*/
