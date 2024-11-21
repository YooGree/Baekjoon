import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P1978_소수찾기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            List<Integer> list = new ArrayList<>();
            for (int j = 1; j <= num; j++) {
                if (num % j == 0) {
                    list.add(j);
                }
            }
            if (list.size() == 2) {
                count++;
            }
        }

        System.out.println(count);
    }
}
