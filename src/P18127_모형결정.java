import java.io.*;
import java.util.StringTokenizer;

public class P18127_모형결정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 결정의 모양
        int b = Integer.parseInt(st.nextToken()); // 온도

        long count = 1;
        long add = 0;

        // 삼각형일떄
        if (a == 3) {
            add = 2;

            while (b-- > 0) {
                count += add;
                add++; // 기본에 늘어난 횟수에서 +1만큼 더 늘어난다.
            }

            // 삼각형이 아닐때
        } else {
            add = a - 1;

            while (b-- > 0) {
                count += add;
                add += a - 2; // 기존에 늘어난 횟수에서 +(a - 2)만큼 더 늘어난다.
            }
        }

        bw.write(Long.toString(count));
        bw.flush();
        bw.close();
        br.close();
    }
}
