import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bfr.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int[] mainArr = new int[N];

        // 정렬하면서 데이터를 넣는다.
        stz = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < N; i++) {
            int target = mainArr[i] = Integer.parseInt(stz.nextToken());
//            int j = i - 1;
//            while (j >= 0 && target < mainArr[j]) {
//                int temp = mainArr[j + 1];
//                mainArr[j + 1] = mainArr[j];
//                mainArr[j] = temp;
//                j--;
//            }
        }

        Arrays.sort(mainArr);

        // 검색대상 데이터를 선언한다.
        stz = new StringTokenizer(bfr.readLine());
        int M = Integer.parseInt(stz.nextToken());

        // 검색대상 데이터가 메인배열에 존재하는지 이진탐색을 진행한다.
        StringBuilder sb = new StringBuilder();
        stz = new StringTokenizer(bfr.readLine());
        for (int i = 0; i < M; i++) {
            int result = binarySearch(mainArr, 0, mainArr.length - 1, Integer.parseInt(stz.nextToken()));
            sb.append(result + "\n");
        }

        System.out.println(sb.toString());
    }

    private static int binarySearch(int A[], int low, int high, int value) {
        while (low <= high) {
            int mid = (low + high) / 2;
            if (A[mid] == value) {
                return 1;
            } else if (A[mid] < value) {
                low = mid + 1;
            } else  {
                high = mid - 1;
            }
        }
        return 0;
    }
}
