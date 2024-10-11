import java.util.Scanner;

public class P10807_개수세기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int find = sc.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            if (find == arr[i]) {
                sum++;
            }
        }

        System.out.println(sum);
    }
}
