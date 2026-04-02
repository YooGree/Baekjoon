import java.util.Scanner;

public class P16495_열순서 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        long result = 0;

        for (int i = 0; i < s.length(); i++) {
            // 26진법 계산: 이전 결과에 26을 곱하고 현재 문자 값을 더함
            result = result * 26 + (s.charAt(i) - 'A' + 1);
        }

        System.out.println(result);
        sc.close();
    }
}
