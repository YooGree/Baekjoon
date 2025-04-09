import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2028_자기복제수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            if(isSelfReplicating(N)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
        br.close();
    }

    public static boolean isSelfReplicating(int N) {
        int square = N * N; // N의 제곱 계산
        String squareStr = String.valueOf(square); // 제곱수를 문자열로 변환
        String NStr = String.valueOf(N); // N을 문자열로 변환

        // 제곱수의 마지막 자리가 N과 일치하는지 확인
        return squareStr.endsWith(NStr);
    }
}
