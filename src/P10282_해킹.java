import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10282_해킹 {
    static class Computer implements Comparable<Computer> {
        @Override
        public int compareTo(Computer o) {
            // 비용 오름차순 정렬
            if (this.cost < o.cost) return -1;
            if (this.cost > o.cost) return 1;
            if (this.next < o.next) return -1;
            if (this.next > o.next) return 1;
            return 0;
        }

        int next;
        int cost;
        public Computer(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    final static int INF = Integer.MAX_VALUE;
    static int n, d, c;
    static ArrayList<Computer>[] computerAj;
    static int[] dist;

    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T > 0) {
            T--;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터의 개수
            d = Integer.parseInt(st.nextToken()); // 의존성의 개수
            c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터의 번호
            computerAj = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                computerAj[i] = new ArrayList<>();
            }
            dist = new int[n + 1];
            Arrays.fill(dist, INF);

            for (int i = 0; i < d; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()); // 이 컴퓨터가
                int b = Integer.parseInt(st.nextToken()); // 이 컴퓨터를 의존한다.
                int s = Integer.parseInt(st.nextToken()); // 비용
                //computerAj[a].add(new Computer(b, s));
                computerAj[b].add(new Computer(a, s));
            }

            dijkstra(c);

            int cnt = 0;
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (dist[i] != INF) {
                    cnt++;
                    max = Math.max(max, dist[i]);
                }
            }

            System.out.print(cnt + " " + max);
            System.out.println();
        }
    }

    private static void dijkstra(int start) {
        PriorityQueue<Computer> pq = new PriorityQueue<>();
        pq.add(new Computer(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Computer cur = pq.poll();
            int curComputer = cur.next;
            int curCost = cur.cost;

            if (dist[curComputer] < curCost) continue;

            for (Computer nextComputer : computerAj[curComputer]) {
                int newCost = dist[curComputer] + nextComputer.cost;
                if (dist[nextComputer.next] > newCost) {
                    dist[nextComputer.next] = newCost;
                    pq.add(new Computer(nextComputer.next, newCost));
                }
            }

        }
    }
}
