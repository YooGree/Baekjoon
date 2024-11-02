import java.util.Scanner;

public class P10988_팰린드롬인지확인하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String word = sc.nextLine();
        sc.close();
        int len = word.length();
        int answer = 1;

        for (int i = 0; i < len / 2; i++) {
            if (word.charAt(i) != word.charAt(len - 1 - i)) {
                answer = 0;
            }
        }

        System.out.println(answer);
    }
}
