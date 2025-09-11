import java.io.*;
import java.util.StringTokenizer;

public class P31962_등교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 버스의 수
        int x = Integer.parseInt(st.nextToken()); // 학교 도착 시간

        int maxStartTime = -1;	// 가장 늦게 도착하는 버스의 출발 시간
        int sum = 0;			// 총 시간
        int startTime;			// 버스를 기다리는 시간
        int takeTime;			// 버스가 학교까지 가는 시간

        // 버스의 수만큼 반복
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            startTime = Integer.parseInt(st.nextToken());
            takeTime = Integer.parseInt(st.nextToken());
            sum = startTime + takeTime;

            // 학교에 도착하면서 가장 늦게 출발할 때
            if (sum <= x && maxStartTime < startTime) {
                maxStartTime = startTime;
            }
        }

        bw.write(Integer.toString(maxStartTime));
        bw.flush();
        bw.close();
        br.close();
    }
}
