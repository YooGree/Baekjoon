import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int total = 0;  //모든 수의 제곰된 값을 더할 변수
        while (st.hasMoreTokens()) {
            int a = Integer.parseInt(st.nextToken());
            total += a*a;
        }
        System.out.print(total % 10);
    }
}
