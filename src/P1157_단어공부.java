import java.util.Scanner;

public class P1157_단어공부 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[26]; // 영문자의 개수
        String s = sc.next();

        for (int i = 0; i < s.length(); i++) {
            if ('A' <= s.charAt(i) && s.charAt(i) <= 'Z') { // 대문자의 범위
                arr[s.charAt(i) - 'A']++; // 해당 인덱스값 1 증가
            } else { // 소문자의 범위
                arr[s.charAt(i) - 'a']++;
            }
        }

        int max = -1;
        char ch = '?';

        for (int i = 0; i < 26; i++) {
            if (arr[i] > max) {
                max = arr[i];
                ch = (char)(i + 65); // 대문자로 출력해야하기 때문에 65를 더한다.
            } else if (arr[i] == max) {
                ch = '?';
            }
        }

        System.out.println(ch);
    }
}
