import java.util.Scanner;

public class P10872_팩토리얼 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int ans = 1;

        for (int i = 1; i < N + 1; i++) {
            ans *= i;
        }

        System.out.println(ans);
    }
}
