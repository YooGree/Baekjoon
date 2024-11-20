import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P9506_약수들의합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == -1) {
                break;
            }

            List<Integer> numList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (n % i == 0) {
                    if (n != i) {
                        numList.add(i);
                    }
                }
            }

            if (n == numList.stream().mapToInt(Integer::intValue).sum()) {
                // 완전수일때
                System.out.print(n + " = ");
                for (int i = 0; i < numList.size(); i++) {
                    if (i == numList.size() -1) {
                        System.out.print(numList.get(i));
                    } else {
                        System.out.print(numList.get(i) + " + ");
                    }
                }
                System.out.println();
            } else {
                // 완전수가 아닐때
                System.out.println(n + " is NOT perfect.");
            }

        }
    }
}
