import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1159_농구경기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] datArr = new int[130];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            datArr[str.charAt(0)]++;
        }

        String ans = "";
        for (int i = 'A'; i <= 'z'; i++) {
            if (datArr[i] >= 5) {
                ans += (char)i;
            }
        }

        if (ans.isEmpty()) {
            System.out.println("PREDAJA");
        } else {
            System.out.println(ans);
        }
    }
}
