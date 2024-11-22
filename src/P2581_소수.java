import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2581_소수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int M = sc.nextInt();
        int N = sc.nextInt();
        List<Integer> list = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            int count = 0;
            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count == 2) {
                list.add(i);
            }
        }

        if (!list.isEmpty()) {
            System.out.println(list.stream().mapToInt(Integer::intValue).sum()); // 합
            System.out.println(list.stream().mapToInt(Integer::intValue).min().orElseThrow()); // 최솟값
        } else {
            System.out.println(-1);
        }
    }
}
