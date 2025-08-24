import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P33753_주차요금정산하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int ans = A;

        int parkingTime = Integer.parseInt(br.readLine());
        if (parkingTime > 30) {
            int overTime = parkingTime - 30;
            int over = overTime / B;
            int left = overTime % B;
            ans += (over * C);

            if (left > 0) {
                ans += C;
            }
        }

        System.out.println(ans);
    }
}
