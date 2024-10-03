import java.util.Scanner;

public class P25314_코딩은체육과목입니다 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int val = N / 4;
        String ans = "";

        for (int i = 0; i < val; i++) {
            if (i == 0) {
                ans = "long";
            } else {
                ans = ans + " " + "long";
            }
        }
        System.out.println(ans + " " + "int");
    }
}
