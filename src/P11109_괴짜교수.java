import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11109_괴짜교수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            //병렬시간이 더 오래 걸리면 do not parallelize sb에 저장
            //같을경우 does not matter sb에 저장
            //직렬시간이 더 오래 걸리면 parallelize sb에 저장
            if((n * s) < ((n * p) + d)) sb.append("do not parallelize").append("\n");
            else if((n * s) == ((n * p) + d)) sb.append("does not matter").append("\n");
            else sb.append("parallelize").append("\n");
        }
        System.out.println(sb);
    }
}
