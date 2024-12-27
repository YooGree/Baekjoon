import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class P14425_문자열집합 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(sc.next());
        }

        int ans = 0;
        for (int i = 0; i < M; i++) {
            String str = sc.next();
            if (set.contains(str)) {
                ans++;
            }
        }

        System.out.println(ans);

    }
}
