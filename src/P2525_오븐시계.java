import java.util.Scanner;

public class P2525_오븐시계 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int H = sc.nextInt();
        int M = sc.nextInt();
        int min = sc.nextInt();

        if (M + min > 59) {
            int temp = (M + min);
            M = temp % 60;
            H += temp / 60;
            if (H > 23) {
                H -= 24;
            }
        } else {
            M += min;
        }
        System.out.println(H + " " + M);
    }
}
