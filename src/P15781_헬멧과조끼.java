import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15781_헬멧과조끼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new  StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 헬멧의 개수
        int M = Integer.parseInt(st.nextToken()); // 조끼의 개수

        int nMax = Integer.MIN_VALUE;
        int mMax = Integer.MIN_VALUE;

        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num =  Integer.parseInt(st.nextToken());
            nMax = Math.max(nMax, num);
        }

        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num =  Integer.parseInt(st.nextToken());
            mMax = Math.max(mMax, num);
        }

        System.out.println(nMax + mMax);
    }

}
