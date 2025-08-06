import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P11779_최소비용구하기2 {
    static class City implements Comparable<City> {
        @Override
        public int compareTo(City o) {
            // 비용 오름차순 정렬
            if (this.cost < o.cost) return -1;
            if (this.cost > o.cost) return 1;
            if (this.next < o.next) return -1;
            if (this.next > o.next) return 1;
            return 0;
        }

        int next;
        int cost;
        public City(int next, int cost) {
            this.next = next;
            this.cost = cost;
        }
    }
    static int n, m;
    static ArrayList<City>[] cityList;
    static int[] dist;
    static int[] prevCity; // 경로 역추적용
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); // 도시의 개수
        m = Integer.parseInt(br.readLine()); // 버스의 개수
        cityList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            cityList[i] = new ArrayList<>();
        }
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        prevCity = new int[n + 1];
        Arrays.fill(prevCity, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            cityList[start].add(new City(end, cost));
        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        dijkstra(start);

        System.out.println(dist[end]);
        
        // 경로 역추적
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.push(end);
        while (prevCity[end] != -1) {
            stack.push(prevCity[end]);
            end = prevCity[end];
        }

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();

    }

    private static void dijkstra(int start) {
        PriorityQueue<City> pq = new PriorityQueue<>();
        pq.add(new City(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            City cur = pq.poll();
            int curCity = cur.next;
            int curCost = cur.cost;

            if (dist[curCity] < curCost) continue;

            for (City nextCity : cityList[curCity]) {
                int newCost = dist[curCity] + nextCity.cost;
                if (dist[nextCity.next] > newCost) {
                    dist[nextCity.next] = newCost;
                    pq.add(new City(nextCity.next, newCost));
                    prevCity[nextCity.next] = curCity; // 이전 도시 기록
                }
            }

        }
    }
}
