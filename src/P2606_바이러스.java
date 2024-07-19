import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class P2606_바이러스 {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        count = 0;

        for (int i = 1; i < V + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        Arrays.fill(visited, false);

        for (int i = 0; i < E; i++) {
            int inStart = sc.nextInt();
            int inEnd = sc.nextInt();
            graph[inStart].add(inEnd);
            graph[inEnd].add(inStart);
        }

        DFS(1);
        System.out.println(--count); // 1번 컴퓨터는 횟수를 제외해야하므로 1을 빼준다.
    }

    static void DFS(int start) {
        if (!visited[start]) {
            count++;
            visited[start] = true;
        }
        for (int i = 0; i < graph[start].size(); i++) {
            if (!visited[graph[start].get(i)]) {
                DFS(graph[start].get(i));
            }
        }
    }
}
