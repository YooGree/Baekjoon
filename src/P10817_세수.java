import java.util.Scanner;

public class P10817_세수 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();

        in.close();

        if (a >= b) {
            if (a >= c) {	// a가 가장 크거나 모두 같을 경우
                if (b >= c)
                    System.out.println(b);
                else
                    System.out.println(c);
            } else
                System.out.println(a);
        } else {
            if (c <= b) { 	// b가 가장 큰 수일 경우
                if (c <= a)
                    System.out.println(a);
                else
                    System.out.println(c);
            } else
                System.out.println(b);
        }
    }
}
