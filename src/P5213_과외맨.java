import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5213_과외맨 {
    static int N;
    static int[][] map; // 입력 받는 숫자들
    static int[][] tileMap; // 타일 번호 기록할 배열

    static boolean[][] isVisited; // bfs에서 사용할 방문 처리 배열

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][2 * N + 1]; // 입력 받는 숫자들
        tileMap = new int[N + 1][2 * N + 1]; // 타일 번호 기록할 배열
        isVisited = new boolean[N + 1][2 * N + 1]; // bfs에서 사용할 방문 처리 배열

        int tileNum = 1; // 타일 번호
        for(int i=1; i<=N; i++) {
            // 홀수 줄
            if(i % 2 == 1) {
                for(int j=1; j<=2*N; j+=2) {
                    st = new StringTokenizer(br.readLine(), " ");
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map[i][j+1] = Integer.parseInt(st.nextToken());

                    tileMap[i][j] = tileNum;
                    tileMap[i][j+1] = tileNum;

                    tileNum++;
                }
            }
            // 짝수 줄
            else {
                map[i][1] = 0;
                for(int j=2; j<=2*(N-1); j+=2) {
                    st = new StringTokenizer(br.readLine(), " ");
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map[i][j+1] = Integer.parseInt(st.nextToken());

                    tileMap[i][j] = tileNum;
                    tileMap[i][j+1] = tileNum;

                    tileNum++;
                }
                map[i][2*N] = 0;
            }
        }

        Pos ans = bfs(1, 1); // 구한 타일 반환

        System.out.println(ans.path.size()); // 해당 타일에 기록되어 있는 경로 크기 출력

        // 해당 타일에 기록되어 있는 경로들 출력
        for(Integer i : ans.path) {
            System.out.print(i + " ");
        }
    }

    static Pos bfs(int x, int y) {
        Pos ans = null; // 반환할 객체
        int max = 0;

        Queue<Pos> que = new LinkedList<>();
        ArrayList<Integer> path = new ArrayList<>(); // 경로를 담을 리스트

        path.add(1); // 첫 시작은 1번 타일

        // 첫번째 위치에서 시작하면 해당 타일에 있는 두 위치를 모두 큐에 넣어줌
        que.add(new Pos(x, y, path));
        que.add(new Pos(x, y+1, path));
        isVisited[x][y] = true;
        isVisited[x][y + 1] = true;

        while(!que.isEmpty()) {
            Pos p = que.poll();

            int curX = p.x;
            int curY = p.y;
            ArrayList<Integer> curPath = p.path;

            // 타일 번호가 큰 것을 계속 갱신함
            if(tileMap[curX][curY] > max) {
                max = tileMap[curX][curY]; // 타일 번호 더 큰 것으로 갱신
                ans = p; // 갱신 될 때 해당 객체로 갱신
            }

            // 탐색 시작
            for(int t=0; t<4; t++) {
                int nx = curX + dx[t];
                int ny = curY + dy[t];

                // 범위를 벗어났거나 빈 칸이거나 이미 방문했다면 continue
                if(nx < 1 || ny < 1 || nx > N || ny > 2*N || map[nx][ny] == 0 || isVisited[nx][ny]) continue;

                // 다른 타일로 넘어갈 수 있을 때
                if(map[curX][curY] == map[nx][ny]) {
                    ArrayList<Integer> nPath = new ArrayList<>();
                    nPath.addAll(curPath); // 이 때 까지 지나온 경로를 모두 새로 담아줌
                    nPath.add(tileMap[nx][ny]); // 해당 위치가 있는 타일을 추가해줌

                    // 탐색한 타일의 칸을 큐에 넣음
                    que.add(new Pos(nx, ny, nPath));
                    isVisited[nx][ny] = true;

                    // 탐색한 타일의 다른 칸을 큐에 넣음
                    // 탐색한 칸이 타일의 왼쪽일 때
                    if(tileMap[nx][ny] == tileMap[nx][ny + 1]) {
                        que.add(new Pos(nx, ny + 1, nPath));
                        isVisited[nx][ny + 1] = true;
                    }
                    // 탐색한 칸이 타일의 오른쪽일 때
                    else if(tileMap[nx][ny - 1] == tileMap[nx][ny]) {
                        que.add(new Pos(nx, ny - 1, nPath));
                        isVisited[nx][ny - 1] = true;
                    }
                }

            }

        }

        return ans;
    }

    static class Pos{
        int x, y;
        ArrayList<Integer> path; // 지나온 경로들을 객체에 함께 담아줌

        Pos(int x, int y, ArrayList<Integer> path){
            this.x = x;
            this.y = y;
            this.path = path;
        }
    }
}
