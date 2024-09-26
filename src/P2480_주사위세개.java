import java.util.Scanner;

public class P2480_주사위세개 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int money = 0;

        if (A == B && B == C) {
            // 3개 동일한 경우
            money = 10000 + A * 1000;
        } else if (A == B || A == C || B == C) {
            // 2개 동일한 경우
            int val;
            if (A == B) {
                val = A;
            } else if (B == C) {
                val = B;
            } else {
                val = C;
            }
            money = 1000 + val * 100;
        } else {
            // 모두 다 다른경우
            int val = Math.max(Math.max(A, B), C);
            money = val * 100;
        }

        System.out.println(money);
    }
}
