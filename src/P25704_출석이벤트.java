import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25704_출석이벤트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());  // 도장 개수
        int P = Integer.parseInt(br.readLine());  // 물건 가격

        int ans = P;  // 쿠폰을 하나도 안 쓰는 경우가 기본값

        if (N >= 5) {
            ans = Math.min(ans, P - 500);
        }
        if (N >= 10) {
            ans = Math.min(ans, P * 9 / 10);   // 10% 할인
        }
        if (N >= 15) {
            ans = Math.min(ans, P - 2000);
        }
        if (N >= 20) {
            ans = Math.min(ans, P * 3 / 4);   // 25% 할인
        }

        if (ans < 0) ans = 0;  // 가격이 음수면 0으로

        System.out.println(ans);
    }
}
