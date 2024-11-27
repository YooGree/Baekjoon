import java.util.Scanner;

public class P15894_수학은체육과목입니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();

        long ans = n + (2 * n) + (n - 1) + 1;
        System.out.println(ans);
    }
}
