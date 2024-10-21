import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P3052_나머지 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int num = sc.nextInt();
            int ans = num % 42;
            if (!list.contains(ans)) {
                list.add(ans);
            }
        }
        System.out.println(list.size());
    }
}
