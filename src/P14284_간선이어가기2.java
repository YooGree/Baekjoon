import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P14284_간선이어가기2 {
    static int N; // 정점의 갯수
    static int M; // 간선의 갯수
    static ArrayList<Node>[] linkList; // 인접 리스트
    static boolean[] visited; // 방문 체크 배열
    static int[] dist; // 최단거리 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        linkList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        dist = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {
            linkList[i] = new ArrayList<>();
            dist[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            linkList[a].add(new Node(b, c));
            linkList[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        dijkstra(start);

        System.out.println(dist[end]);
    }

    public static class Node implements Comparable<Node> {
        int node;
        int cost;

        public Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(start, 0));
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node cNode = queue.poll();
            if (!visited[cNode.node]) {
                visited[cNode.node] = true;
            }
            for (Node linkNode : linkList[cNode.node]) {
                if (!visited[linkNode.node] && dist[linkNode.node] > dist[cNode.node] + linkNode.cost) {
                    dist[linkNode.node] = dist[cNode.node] + linkNode.cost;
                    queue.offer(new Node(linkNode.node, dist[linkNode.node]));
                }
            }
        }
    }
}
