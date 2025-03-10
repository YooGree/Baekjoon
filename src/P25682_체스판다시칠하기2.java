import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P25682_체스판다시칠하기2 {
    static int N, M, K;
    static String[] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder str = new StringBuilder();

        // MxN 크기의 보드
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        // KxK 크기의 체스판으로 만듦
        K = Integer.parseInt(st.nextToken());

        // B: 검은색, W: 흰색
        board = new String[N];
        for(int n = 0; n < N; n++)
            board[n] = br.readLine();

        // 어떤 색으로 시작했을 때 더 효율적인지?
        str.append(Math.min(makeBoard('B'), makeBoard('W')));

        // KxK 보드를 체스판으로 만들기 위해 다시 칠해야 하는 정사각형 개수의 최솟값
        System.out.print(str);
        br.close();
    }

    // 해당 색깔로 시작하는 보드를 만들었을 때 다시 칠해야하는 정사각형 개수
    public static int makeBoard(char color){
        // 다시칠해야 하는 최솟값
        int cnt = Integer.MAX_VALUE;
        // 다시 칠해야하는 색깔의 누적 합
        int[][] dp = new int[N+1][M+1];
        // 누적합에 더할지 말지 판단
        int value = 0;

        for(int n = 0; n < N; n++){
            for(int m = 0; m < M; m++){
                // 짝수마다 color 색이어야 한다.
                if((n+m)%2 == 0)
                    value = board[n].charAt(m) != color? 1 : 0;
                    // 홀수마다 color 반대색이어야 한다.
                else
                    value = board[n].charAt(m) == color? 1 : 0;

                // 누적합에 저장
                dp[n+1][m+1] = dp[n][m+1] + dp[n+1][m] - dp[n][m] + value;
            }
        }

        // 누적합을 통해 최솟값 판단
        for(int n = 1; n <= N-K+1; n++){
            for(int m = 1; m <= M-K+1; m++){
                cnt = Math.min(cnt,
                        // 행 누적값
                        dp[n+K-1][m+K-1] - dp[n+K-1][m-1]
                                // 열 누적값
                                - dp[n-1][m+K-1] + dp[n-1][m-1]);
            }
        }

        // 최솟값 출력
        return cnt;
    }
}
