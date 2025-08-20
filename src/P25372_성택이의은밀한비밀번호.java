import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25372_성택이의은밀한비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            int len = br.readLine().length();
            sb.append(len>=6&&len<=9 ? "yes\n" : "no\n");
        }
        System.out.print(sb);
    }
}
