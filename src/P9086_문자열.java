import java.util.Scanner;

public class P9086_문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String value = sc.next();
            String result = String.valueOf(value.charAt(0)) + String.valueOf(value.charAt(value.length() - 1));
            System.out.println(result);
        }
    }
}
