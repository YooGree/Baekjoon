import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine()); // 사람의 수
        int[] time = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(time); // 오름차순 정렬
        int[] sumTime = new int[N];
        sumTime[0] = time[0];
        for (int i = 1; i < N; i++) {
            sumTime[i] = time[i] + sumTime[i - 1]; // 현재시간 + 이전 누적시간
        }
        System.out.println(Arrays.stream(sumTime).sum());
    }
}
