import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10811_바구니뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] baguni = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            baguni[i] = i;
        }

        for (int a = 0; a < M; a++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            while (i < j) {
                int temp = baguni[i];
                baguni[i++] = baguni[j];
                baguni[j--] = temp;
            }
        }

        for (int i = 1; i < baguni.length; i++) {
            System.out.print(baguni[i] + " ");
        }

        System.out.println();
    }
}
