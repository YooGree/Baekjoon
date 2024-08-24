import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16928_뱀과사다리게임 {
    static int N; // 사다리의 수
    static int M; // 뱀의 수
    static int[] ladderAndSnake; // 사다리와 뱀 정보
    static boolean[] visited; // 방문 체크 배열
    static int[] count; // 주사위 굴리는 횟수 저장 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ladderAndSnake = new int[101];
        visited = new boolean[101];
        count = new int[101];

        // 사다리와 뱀 정보 추가
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()); // 출발점
            int end = Integer.parseInt(st.nextToken()); // 도착점
            ladderAndSnake[start] = end;
        }

        bfs(1);
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            if (current == 100) {
                // 도착했다면 return
                System.out.println(count[current]);
                return;
            }

            // 주사위 눈의 수만큼 반복
            for (int i = 1; i < 7; i++) {
                int mCurrent = current + i;
                if (mCurrent > 100) continue;
                if (visited[mCurrent]) continue;
                visited[mCurrent] = true;

                if (ladderAndSnake[mCurrent] != 0) {
                    // 사다리 또는 뱀의 위치일때
                    if (!visited[ladderAndSnake[mCurrent]]) {
                        q.offer(ladderAndSnake[mCurrent]);
                        visited[ladderAndSnake[mCurrent]] = true;
                        count[ladderAndSnake[mCurrent]] = count[current] + 1;
                    }
                } else {
                    // 아무것도 아닐때
                    q.offer(mCurrent);
                    visited[mCurrent] = true;
                    count[mCurrent] = count[current] + 1;
                }
            }

        }
    }
}
