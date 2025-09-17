import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5524_입실관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String cur = br.readLine();
            sb.append(cur.toLowerCase()).append('\n');
        }
        System.out.print(sb);
    }
}
