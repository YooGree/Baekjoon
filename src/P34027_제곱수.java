import java.util.Scanner;

public class P34027_제곱수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int num = scanner.nextInt();
            if (isSquare(num)) {
                sb.append(1 + "\n");
            } else {
                sb.append(0 + "\n");
            }
        }

        System.out.println(sb.toString());
        scanner.close();
    }

    public static boolean isSquare(int n) {
        if (n < 0) {
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}
