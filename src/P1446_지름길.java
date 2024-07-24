import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1446_지름길 {
    static int N;
    static int D;
    static ArrayList<Node> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 지름길의 갯수
        D = Integer.parseInt(st.nextToken()); // 고속도로의 길이
        graph = new ArrayList<>(); // 고속도로 그래프
        dist = new int[100001]; // 최단거리를 저장할 배열
        for (int i = 1; i < 100001; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (D < e) continue;
            if (e - s <= c) continue; // 지름길이 더 먼 경우 Skip
            graph.add(new Node(s, e, c));
        }

        Collections.sort(graph);

        shortRoot();

        System.out.println(dist[D]);
    }

    public static class Node implements Comparable<Node> {
        public int start;
        public int end;
        public int cost;
        public Node(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.start == o.start) return this.end - o.end;
            return this.start - o.start;
        }
    }

    static void shortRoot() {
        int index = 0;
        int move = 0;
        while (move < D) {
            if (index < graph.size()) {
                Node node = graph.get(index);
                if (move == node.start) {
                    dist[node.end] = Math.min(dist[move] + node.cost, dist[node.end]);
                    index++;
                } else {
                    dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
                    move++;
                }
            } else {
                dist[move + 1] = Math.min(dist[move] + 1, dist[move + 1]);
                move++;
            }
        }
    }
}
