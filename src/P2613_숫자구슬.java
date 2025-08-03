import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2613_숫자구슬 {
    static int N, M;
    static int[] arr;
    static int[] ansArr;
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new  StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 구슬의 개수
        M = Integer.parseInt(st.nextToken()); // 만들 그룹의 수
        arr = new int[N];
        ansArr = new int[M];

        int min = Integer.MAX_VALUE;
        int sum = 0;
        st = new  StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            min = Math.min(min, num);
            sum += num;
        }

        int answer = parametricSearch(min, sum);

        // 그룹의 숫자구슬 개수가 0개인건 없애기
         groupCheck();

         System.out.println(answer);
         for (int i = 0; i < ansArr.length; i++) {
             System.out.print(ansArr[i] + " ");
         }
    }

    static int parametricSearch(int left, int right) {
         int answer = -1;

         while (left <= right) {
             int mid = (left + right) / 2;
             if (isValid(mid)) { // 3개의 그룹으로 나누어 진다면
                 right = mid - 1;
                 answer = mid;
             } else {
                 left = mid + 1;
             }
         }

         return answer;
    }

    static boolean isValid(int mid) {
        int groupIndex = 0;
        int groupSum = 0;
        int[] groupCount = new int[M];

        for (int i = 0; i < arr.length; i++) {
            if (mid < arr[i]) return false; // 현재 지정된 최대값보다 구슬숫자가 더 크면 false
            if (groupSum + arr[i] <= mid) { // 현재 그룹에 현재 구슬숫자를 더해도 최대값이 넘지 않으면 더하기
                groupSum += arr[i];
            } else {
                groupSum = arr[i];
                groupIndex++;
            }
            if (groupIndex == M) return false; // 그룹의 개수가 M + 1이 넘으면 false
            groupCount[groupIndex]++;
        }

        ansArr = groupCount;
        return true;
    }

    public static void groupCheck(){
        int idx = 0;

        for (int i = 0; i < M; i++){
            if (ansArr[i] == 0){
                idx = i - 1;
                ansArr[i]++;
                while (true){
                    if (ansArr[idx] != 1) {
                        break;
                    }
                    idx--;
                }
                ansArr[idx]--;
            }
        }
    }
}
