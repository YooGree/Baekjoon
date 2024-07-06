import java.util.Scanner;

public class P1929_소수구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(); // 시작값
        int N = sc.nextInt(); // 끝값
        int[] A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (i == 1) A[i] = 0;
            else A[i] = i;
        }
        
        // 에라토스테네스의 체
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (A[i] == 0) continue;
            for (int j = i + i; j <= N; j = j + i) {
                A[j] = 0;
            }
        }

        for (int i = M; i <= N; i++) {
            if (A[i] != 0) {
                System.out.println(A[i]);
            }
        }
    }
}
