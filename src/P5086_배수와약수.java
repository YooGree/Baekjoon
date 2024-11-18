import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P5086_배수와약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int A, B;
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if (A == 0 && B == 0) {
                break;
            }

            if (B % A == 0) {
                // A가 B의 약수라면
                System.out.println("factor");
            } else if (A % B == 0) {
                // A가 B의 배수라면
                System.out.println("multiple");
            } else {
                // 둘 다 아니라면
                System.out.println("neither");
            }
        }
    }
}
