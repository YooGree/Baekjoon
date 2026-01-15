import java.util.Scanner;

public class P20361_일우는야바위꾼 {

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);

        int cupNum = sc.nextInt();
        int ball = sc.nextInt();
        int N = sc.nextInt();

        int[] arr = new int[cupNum];
        arr[ball - 1] = 1;

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int temp = 0;

            temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
