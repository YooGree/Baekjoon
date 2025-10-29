import java.util.Scanner;

public class P19602_DogTreats {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int M = sc.nextInt();
        int L = sc.nextInt();
        //(1)

        int result = S + (2 * M) + (3 * L);
        //(2)
        System.out.println(result > 9 ? "happy" : "sad");
        //(3)
    }
}
