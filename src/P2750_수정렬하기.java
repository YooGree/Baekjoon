import java.util.Scanner;
public class P2750_수정렬하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] numArr = new int[N];
        boolean noSwap = false;

        for (int i = 0; i < N; i++) {
            numArr[i] = sc.nextInt();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = 0; j < N - 1 - i; j++) {
                if (numArr[j] > numArr[j + 1]) {
                    int temp = numArr[j];
                    numArr[j] = numArr[j + 1];
                    numArr[j + 1] = temp;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(numArr[i]);
        }
    }
}
