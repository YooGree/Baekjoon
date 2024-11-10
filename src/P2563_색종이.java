import java.util.Scanner;

public class P2563_색종이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] allArr = new int[101][101];
        int total = 0;
        int paperCount = sc.nextInt();

        for (int i = 0; i < paperCount; i++) {
            int colStart = sc.nextInt();
            int rowStart = sc.nextInt();

            for (int row = rowStart; row < rowStart + 10; row++) {
                for (int col = colStart; col < colStart + 10; col++) {
                    if (allArr[row][col] == 0) {
                        allArr[row][col] = 1;
                        total++;
                    }
                }
            }
        }

        System.out.println(total);
    }
}
