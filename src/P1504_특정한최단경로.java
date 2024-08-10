import java.io.*;
import java.util.*;

public class P1504_특정한최단경로 {
    static int N; // 정점의 갯수
    static int E; // 간선의 갯수
    static ArrayList<ArrayList<Node>> A; // 인접리스트
    static int[] dist; // 각 정점으로 가는 최단거리
    static boolean[] visited; // 방문 확인
    static final int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        A = new ArrayList<>();
        dist = new int[N + 1];
        visited = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(visited, false);

        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        // 양방향 인접리스트 구현
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            A.get(start).add(new Node(end, cost));
            A.get(end).add(new Node(start, cost));
        }

        // 반드시 거쳐야 하는 정점
        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // case1. 1 -> v1 -> v2 -> N 으로 가는경우 최단거리
        int cost1 = 0;
        cost1 += dijkstra(1, v1);
        cost1 += dijkstra(v1, v2);
        cost1 += dijkstra(v2, N);

        // case2. 1 -> v2 -> v1 -> N 으로 가는경우 최단거리
        int cost2 = 0;
        cost2+= dijkstra(1, v2);
        cost2 += dijkstra(v2, v1);
        cost2 += dijkstra(v1, N);

        int answer = (cost1 >= INF && cost2 >= INF) ? -1 : Math.min(cost1, cost2);

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        // 중복 방문 허용이므로 초기화
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cNode = pq.poll(); // 현재노드
            int cNodeIdx = cNode.end;

            if (!visited[cNodeIdx]) {
                visited[cNodeIdx] = true;

                // 현재 노드에 인접한 노드 리스트들
                for (Node node : A.get(cNodeIdx)) {
                    if (!visited[node.end] && dist[node.end] > dist[cNodeIdx] + node.cost) {
                        dist[node.end] = dist[cNodeIdx] + node.cost;
                        pq.offer(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }

        return dist[end];
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
