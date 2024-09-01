import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1967_트리의지름 {
    static int n; // 노드의 개수
    static ArrayList<Node>[] list; // 인접 리스트
    static boolean[] visited; // 방문 체크 배열
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        max = 0;
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 부모 노드
            int end = Integer.parseInt(st.nextToken()); // 자식 노드
            int cost = Integer.parseInt(st.nextToken()); // 가중치
            list[start].add(new Node(end, cost));
            list[end].add(new Node(start, cost));
        }

        for (int i = 1; i < n + 1; i++) {
            Arrays.fill(visited, false);
            dfs(i, 0);
        }

        System.out.println(max);
    }

    public static void dfs (int start, int cost) {
        visited[start] = true;
        max = Math.max(cost, max);
        for (int i = 0; i < list[start].size(); i++) {
            Node linkNode = list[start].get(i);
            if (!visited[linkNode.end]) {
                dfs(linkNode.end, cost + linkNode.cost);
            }
        }
    }

    public static class Node {
        int end;
        int cost;
        public Node (int end, int cost) {
            this.end = end;
            this.cost = cost;
        }
    }
}
