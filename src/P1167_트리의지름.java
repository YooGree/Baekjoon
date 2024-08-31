import java.util.ArrayList;
import java.util.Scanner;

public class P1167_트리의지름 {
    static int V; // 트리의 정점의 개수
    static ArrayList<Node>[] list;
    static boolean[] visited;
    static int max;
    static int node;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        V = sc.nextInt();
        max = 0;
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for (int i = 1; i < V + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            int start = sc.nextInt();
            while (true) {
                int end = sc.nextInt();
                if (end == -1) break;
                int cost = sc.nextInt();
                list[start].add(new Node(end, cost));
            }
        }

        // 임의의 노드에서부터 가장 먼 노드를 찾아서 찾은 노드를 node 변수에 저장한다.
        dfs(1, 0);

        // node에서부터 가장 먼 노드까지의 거리를 구한다.
        visited = new boolean[V + 1];
        dfs(node, 0);

        System.out.println(max);
    }

    public static void dfs (int start, int len) {
        if (len > max) {
            // 가장 먼 노드를 찾기
            max = len;
            node = start;
        }
        visited[start] = true;

        for (int i = 0; i < list[start].size(); i++) {
            Node linkNode = list[start].get(i);
            if (!visited[linkNode.end]) {
                dfs(linkNode.end, linkNode.cost + len);
                //visited[linkNode.end] = true;
            }
        }
    }

    public static class Node {
        int end;
        int cost;
        public Node(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
