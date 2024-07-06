import java.util.Scanner;
public class P2018_수들의합5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        int startIndex = 1, endIndex = 1, sum = 1;

        while (endIndex <= N) {
            if (sum > N) {
                sum -= startIndex;
                startIndex++;
            } else if (sum < N) {
                endIndex++;
                sum += endIndex;
            } else {
                count++;
                endIndex++;
                sum += endIndex;
            }
        }

        System.out.println(count);
    }
}
