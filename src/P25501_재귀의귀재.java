import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25501_재귀의귀재 {
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            int ans = isPalindrome(str);
            System.out.println(ans + " " + cnt);
            cnt = 0;
        }

    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }

    public static int recursion(String s, int l, int r){
        cnt++;
        char[] cArr = s.toCharArray();
        if (l >= r) return 1;
        else if (cArr[l] != cArr[r]) return 0;
        else return recursion(s, l + 1, r - 1);
    }
}
