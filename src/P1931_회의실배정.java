import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine()); // 회의의 갯수
        int[][] time = new int[N][2]; // time[][0] : 시작시간, time[][1] : 종료시간

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료시간
        }
        
        // 끝나는 시간 기준으로 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    // 종료시간이 같을경우 시작시간으로 오름차순
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int count = 0;
        int prev_end_time = 0;

        for (int i = 0; i < time.length; i++) {
            if (prev_end_time <= time[i][0]) {
                // 직전 종료시간이 다음 회의 시작시간보다 작거나 같다면 갱신
                prev_end_time = time[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
