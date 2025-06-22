import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2754_학점계산 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String score = br.readLine();
        double ans = 0;

        if (score.equals("A+")) {
            ans = 4.3;
        } else if (score.equals("A0")) {
            ans = 4.0;
        } else if (score.equals("A-")) {
            ans = 3.7;
        } else if (score.equals("B+")) {
            ans = 3.3;
        } else if (score.equals("B0")) {
            ans = 3.0;
        } else if (score.equals("B-")) {
            ans = 2.7;
        } else if (score.equals("C+")) {
            ans = 2.3;
        } else if (score.equals("C0")) {
            ans = 2.0;
        } else if (score.equals("C-")) {
            ans = 1.7;
        } else if (score.equals("D+")) {
            ans = 1.3;
        } else if (score.equals("D0")) {
            ans = 1.0;
        } else if (score.equals("D-")) {
            ans = 0.7;
        } else  {
            ans = 0.0;
        }

        System.out.println(ans);
    }
}
