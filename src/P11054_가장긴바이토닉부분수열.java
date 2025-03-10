import java.util.Arrays;
import java.util.Scanner;

public class P11054_가장긴바이토닉부분수열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] dp1 = new int[n]; // LIS (왼쪽에서 오른쪽)
        int[] dp2 = new int[n]; // LDS (오른쪽에서 왼쪽)

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // LIS 계산
        Arrays.fill(dp1, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // LDS 계산 (뒤에서부터)
        Arrays.fill(dp2, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[i]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        // 최댓값 찾기
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, dp1[i] + dp2[i] - 1);
        }

        System.out.println(maxLen);
    }
}
