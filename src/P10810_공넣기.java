import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10810_공넣기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 바구니 숫자
        int M = Integer.parseInt(st.nextToken()); // 공을 넣는 방법
        int[] baguni = new int[N];

        for (int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for (int b = i - 1; b < j; b++) {
                baguni[b] = k;
            }
        }

        for (int i = 0; i < baguni.length; i++) {
            System.out.print(baguni[i] + " ");
        }
        System.out.println();
    }
}
