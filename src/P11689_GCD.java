import java.util.Scanner;

public class P11689_GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long result = N;

        // 오일러피 구현
        for (long i = 2; i <= Math.sqrt(N); i++) {
            // i가 소수인지 확인
            if (N % i == 0) {
                // 소수인 경우 결과값 변경
                result = result - (result / i);
                while (N % i == 0) {
                    N = N / i;
                }
            }
        }

        if (N > 1) {
            result = result - (result / N);
        }

        System.out.println(result);
    }
}
