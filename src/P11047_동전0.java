import java.util.*;
public class P11047_동전0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Stack<Integer> stack = new Stack<>();
        int minSumCount = 0;

        for (int i = 0; i < N; i++) {
            stack.push(sc.nextInt());
        }

        while (!stack.isEmpty()) {
            int coin = stack.pop();
            if (K == 0) break;
            if (coin > K) continue;

            minSumCount += (K / coin);
            K %= coin;
        }

        System.out.println(minSumCount);
    }
}
