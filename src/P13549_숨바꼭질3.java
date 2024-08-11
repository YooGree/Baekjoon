import java.sql.SQLOutput;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P13549_숨바꼭질3 {
    static int min = Integer.MAX_VALUE;
    static int max = 100000;
    static int N;
    static int K;
    static boolean[] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        visited = new boolean[max + 1];

        BFS();
        System.out.println(min);
    }

    public static void BFS() {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(N, 0));

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.end] = true;

            if (node.end == K) min = Math.min(min, node.cost);

            if (node.end * 2 <= max && !visited[node.end * 2]) {
                q.offer(new Node(node.end * 2, node.cost));
            }
            if (node.end + 1 <= max && !visited[node.end + 1]) {
                q.offer(new Node(node.end + 1, node.cost + 1));
            }
            if (node.end - 1 >= 0 && !visited[node.end - 1]) {
                q.offer(new Node(node.end - 1, node.cost + 1));
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
