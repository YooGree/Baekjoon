import java.util.Scanner;

public class P25304_영수증 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cost = sc.nextInt();
        int N = sc.nextInt();
        int total = 0;
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            total += a * b;
        }

        if (total == cost) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
