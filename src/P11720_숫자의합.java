import java.util.Scanner;
public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        String sNum = scan.next();
        char[] sNumArr = sNum.toCharArray();
        int sum = 0;

        for (char cNum : sNumArr) {
            sum += cNum - '0';
        }

        System.out.println(sum);
    }
}
