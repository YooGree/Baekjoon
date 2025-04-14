import java.util.Scanner;

public class P2520_팬케이크사랑 {
    static double[] needPancake = {0.5, 0.5, 0.25, 0.0625, 0.5625};
    static int[] needTopping = {1, 30, 25, 10};

    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt(); // 테스트 케이스

        // 은주가 만들 수 있는 팬케이크의 최대 개수 구하기
        for (int i = 0; i < t; i++) {
            double canMake1 = 0; // 현재 재료로 만들 수 있는 팬케이크의 수

            for (int j = 0; j < 5; j++) {
                int n = in.nextInt();
                n /= needPancake[j];

                if (j == 0 || n < canMake1) canMake1 = n;
            }

            int canMake2 = 0; // 토핑만 봤을 때 만들 수 있는 팬케이크 수

            for (int j = 0; j < 4; j++) {
                int n = in.nextInt();
                canMake2 += (n / needTopping[j]);
            }

            // 출력
            System.out.println((int) Math.min(canMake1, canMake2));
        }
    }
}
