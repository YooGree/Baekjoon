import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2446_별찍기9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        // 역삼각형 코드
        for (int i = 0; i < N; i++) {	// 1 ~ N

            // 공백
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }

            // 별
            for (int k = 0; k < (2 * N - 1) - (2 * i); k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        // 삼각형 코드
        for (int i = 0; i < N - 1; i++) {	// N+1 ~ 2N-1

            // 공백
            for (int j = 1; j < (N - 1) - i; j++) {
                System.out.print(" ");
            }

            // 별
            for (int k = 0; k < 3 + 2 * i; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
