import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2512_예산 {
    static int[] costArr; // 지역별 요청예산 배열
    static int totalCost; // 국가 총 예산
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        costArr = new int[N];
        st = new StringTokenizer(br.readLine());
        int currentMax = 0;
        for (int i = 0; i < N; i++) {
            int cost = Integer.parseInt(st.nextToken());
            costArr[i] = cost;
            currentMax =  Math.max(currentMax, cost);
        }

        totalCost = Integer.parseInt(br.readLine());

        int answer = parametricSearch(1, currentMax);
        System.out.println(answer);
    }

    static int parametricSearch(int low, int high) {
        int answer = -1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) { // mid값이 현재 국가 예산을 넘지 않는다면 조건 만족
                answer = mid;
                low = mid + 1; // 더 큰 최댓값이 있는지 찾아본다.
            } else { // mid값이 현재 국가 예산을 넘는다면 조건 불만족
                high = mid - 1; // 저 작은 범위 내에서 찾아본다.
            }
        }

        return answer;
    }

    static boolean isValid(int mid) {
        int totalSum = 0;

        for (int i = 0; i < costArr.length; i++) {
            if (costArr[i] > mid) {
                totalSum += mid;
            } else {
                totalSum += costArr[i];
            }
        }

        return totalSum <= totalCost;
    }

}
