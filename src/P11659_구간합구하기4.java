import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class P11659_구간합구하기4 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bfr.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        long[] sArr = new long[N + 1];

        stz = new StringTokenizer(bfr.readLine());

        for (int i = 1; i <= N; i++) {
            sArr[i] = sArr[i - 1] + Integer.parseInt(stz.nextToken());
        }

        for (int q = 0; q < M; q++) {
            stz = new StringTokenizer(bfr.readLine());
            int i = Integer.parseInt(stz.nextToken());
            int j = Integer.parseInt(stz.nextToken());

            System.out.println(sArr[j] - sArr[i - 1]);
        }
    }
}
