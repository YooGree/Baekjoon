import java.util.Scanner;

public class P1546_평균 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int nMax = 0;
        int nSum = 0;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp > nMax)
                nMax = temp;
            nSum += temp;
        }

        System.out.println(nSum * 100.0 / nMax / N);
    }
}
