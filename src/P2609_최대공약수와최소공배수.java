import java.util.Scanner;

public class P2609_최대공약수와최소공배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();

        System.out.println(gcd(A, B));
        System.out.println(lcm(A, B));
    }

    // 최대공약수
    private static int gcd (int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 최소공배수
    private static int lcm (int a, int b) {
        return a * b / gcd(a, b);
    }
}
