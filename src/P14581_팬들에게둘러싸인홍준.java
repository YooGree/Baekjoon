import java.util.Scanner;

public class P14581_팬들에게둘러싸인홍준 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String hongjun = sc.nextLine();
        sc.close();

        System.out.println(":fan::fan::fan:");
        System.out.println(":fan::" + hongjun + "::fan:");
        System.out.println(":fan::fan::fan:");
    }
}
