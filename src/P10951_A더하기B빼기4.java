import java.util.Scanner;

public class P10951_A더하기B빼기4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String[] line = sc.nextLine().split(" ");
            int A = Integer.parseInt(line[0]);
            int B = Integer.parseInt(line[1]);
            System.out.println(A + B);
        }
    }
}
