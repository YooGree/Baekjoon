import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P30008_준영이의등급 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int g = Integer.parseInt(st.nextToken());
            int p = g * 100 / n;

            if (0 <= p  && p <= 4) {
                sb.append("1 ");
            } else if (4 < p && p <= 11) {
                sb.append("2 ");
            } else if (11 < p && p <= 23) {
                sb.append("3 ");
            } else if (23 < p && p <= 40) {
                sb.append("4 ");
            } else if (40 < p && p <= 60) {
                sb.append("5 ");
            } else if (60 < p && p <= 77) {
                sb.append("6 ");
            } else if (77 < p && p <= 89) {
                sb.append("7 ");
            } else if (89 < p && p <= 96) {
                sb.append("8 ");
            } else if (96 < p && p <= 100) {
                sb.append("9 ");
            }
        }

        System.out.println(sb);
    }
}
