import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2661_좋은수열 {
    static int N;
    static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        backTracking("");
    }

    static void backTracking(String current) {
        if (found) {
            return;
        }

        if (current.length() == N) {
            System.out.println(current);
            found = true;
            return;
        }
        
        // 1, 2, 3 중에서 수열이 될 값을 한 개씩 선택
        for (int i = 1; i <= 3; i++) {
            String next = current + i;

            // 좋은 수열인지 검사
            if (isGood(next)) {
                backTracking(next);
            }
        }
    }

    static boolean isGood(String s) {
        int len = s.length();

        // 마지막 k개와 그 앞의 k개가 같은지 검사 (k: 1 ~ len/2)
        for (int i = 1; i <= len / 2; i++) {
            String front = s.substring(len - i); // 마지막 i개
            String back = s.substring(len - 2 * i, len - i); // 그 앞 i개

            if (front.equals(back)) return false;
        }

        return true;
    }


}
