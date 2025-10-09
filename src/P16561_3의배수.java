import java.util.Scanner;

public class P16561_3의배수 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int count = 0, sum = 0;

        for (int i = 1; i < n / 3; i++) {
            for (int j = 1; j < n / 3; j++) {
                sum = 3 * i + 3 * j;
                if (n - sum > 0) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
