import java.util.Scanner;

public class P27886_문자와문자열 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int index = sc.nextInt();

        System.out.println(S.charAt(index - 1));
    }
}
