import java.util.Arrays;
import java.util.Scanner;

public class P5576_콘테스트 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];
        int[] arr2 = new int[10];
        int w = 0;
        int k = 0;
        for (int j = 0; j < 10; j++) {
            arr[j] = sc.nextInt();
        }
        for (int m = 0; m < 10; m++) {
            arr2[m] = sc.nextInt();
        }

        Arrays.sort(arr);
        Arrays.sort(arr2);

        for (int i = 9; i > arr.length-4; i--) {
            w += arr[i];
            k += arr2[i];
        }

        System.out.println(w + " " +k);

    }
}
