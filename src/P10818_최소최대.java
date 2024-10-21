import java.util.Scanner;

public class P10818_최소최대 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int min = 2147000000;
        int max = -2147000000;
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        System.out.println(min + " " + max);
     }
}
