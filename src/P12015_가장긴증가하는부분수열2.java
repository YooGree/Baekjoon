import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P12015_가장긴증가하는부분수열2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];
        int[] LIS = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // LIS 초기 값으로 첫 번째 수열의 값을 갖는다.
        LIS[0] = seq[0];
        int lengthOfLIS = 1;

        for (int i = 1; i < N; i++) {

            int key = seq[i];

            // 만약 key가 LIS의 마지막 값보다 클 경우 추가해준다.
            if (LIS[lengthOfLIS - 1] < key) {
                lengthOfLIS++;
                LIS[lengthOfLIS - 1] = key;
            }
            else {
                // Lower Bound 이분탐색을 진행한다.
                int lo = 0;
                int hi = lengthOfLIS;
                while (lo < hi) {
                    int mid = (lo + hi) >>> 1;

                    if(LIS[mid] < key) {
                        lo = mid + 1;
                    }
                    else {
                        hi = mid;
                    }

                }
                /*
                 *  lo가 LIS에서 대치 될 원소의 위치가 될 것이고
                 *  해당 위치에 key값으로 원소를 바꿔준다.
                 */

                LIS[lo] = key;

            }

        }
        // 위 과정을 통해 나온 LIS의 길이를 출력한다.
        System.out.println(lengthOfLIS);
    }
}
