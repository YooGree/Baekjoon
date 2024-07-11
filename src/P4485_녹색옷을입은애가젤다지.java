
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P4485_녹색옷을입은애가젤다지 {
    static int N;
    static int[][] miro = new int[N][N]; // 인접행렬
    static int[][] dist = new int[N][N]; // 최소비용을 계산해서 넣을 행렬
    static boolean[][] visited = new boolean[N][N]; // 방문을 체크해서 넣을 행렬
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int cnt = 0; // 반복횟수
        while (true) {
            // 동굴의 크기를 나타내는 N 선언 (N * N)
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            /* 다익스트라 알고리즘 순서
             1. 인접행렬에 데이터를 초기화하면서 방문행렬과 비용행렬에 값도 같이 초기화 해준다.
             2. 가중차기 있으므로, x, y, cost 값을 가지는 point 클래스를 선언하고, 우선순위 큐를 위해 compareTo 메서드를 오버라이드 하여 정렬기준을 설정한다.
             3. 우선순위 큐를 선언하고 해당 큐에 시작좌표를 삽입한다.
             4. 큐가 비어있을때까지 각 좌표의 사방탐색(상, 하, 좌, 우)을 진행하고, 비용행렬에 낮은 가중치를 설정한다.
             5. 3 ~ 4 를 큐가 빌때까지 연산한다.
             */
            
            // 1. 인접행렬과 최소비용 행렬 데이터 초기화
            miro = new int[N][N];
            dist = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < miro.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < miro[i].length; j++) {
                    miro[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }

            // 2. 우선순위 큐에 시작좌표를 삽입한다.
            PriorityQueue<point> pQueue = new PriorityQueue<>();
            dist[0][0] = miro[0][0]; // 초기값 설정
            pQueue.offer(new point(0, 0, miro[0][0])); // 시작좌표 우선순위 큐에 삽입

            // 3. 큐가 비어있을때까지 각 좌표의 사방 탐색을 진행한다.
            while (!pQueue.isEmpty()) {
                point p = pQueue.poll();

                // 사방 탐색
                for (int k = 0; k < 4; k++) {
                    int newRow = p.row + dx[k];
                    int newCol = p.col + dy[k];

                    // 범위 검사
                    if (axisValid(newRow, newCol)) {
                        // 기존의 좌표의 가중치가 현재 좌표의 가중치 + 이동할 좌표의 가중치보다 크다면 작은 가중치로 업데이트 하고 큐에 넣는다.
                        if (dist[newRow][newCol] > dist[p.row][p.col] + miro[newRow][newCol]) {
                            dist[newRow][newCol] = dist[p.row][p.col] + miro[newRow][newCol];
                            pQueue.offer(new point(newRow, newCol, dist[newRow][newCol]));
                        }
                    }

                }
            }

            cnt++; // 반복횟수 증가
            System.out.println("Problem " + cnt + ": " + dist[N -1][N - 1]);
        }
    }

    private static boolean axisValid(int row, int col) {
        if (row >= 0 && row < N && col >= 0 && col < N) return true;
        else return false;
    }

    private static class point implements Comparable<point> {
        int row, col, cost;
        public point (int row, int col, int cost) {
            super();
            this.row = row;
            this.col = col;
            this.cost = cost;
        }

        @Override
        public int compareTo(point o) {
            return this.cost - o.cost; // 오름차순 정렬
        }
    }

}
