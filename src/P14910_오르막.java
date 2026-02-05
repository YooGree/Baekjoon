import java.io.IOException;
import java.util.Scanner;

public class P14910_오르막 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        String ret = "Good";
        String[] str = sc.nextLine().split(" ");

        for (int i = 0; i < str.length - 1; i++) {
            int a = Integer.parseInt(str[i]);
            int b = Integer.parseInt(str[i + 1]);
            if (a > b) {
                ret = "Bad";
                break;
            }
        }

        System.out.println(ret);
    }
}
