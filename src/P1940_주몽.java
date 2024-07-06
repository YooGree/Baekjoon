import java.util.Arrays;
import java.util.Scanner;

public class P1940_주몽 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int startIdx = 0, endIdx = N - 1;
        int count = 0;
        int[] nArr = new int[N];

//        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer stz = new StringTokenizer(bfr.readLine());

        for (int i = 0; i < N; i++) {
//            nArr[i] = Integer.parseInt(stz.nextToken());
            nArr[i] = sc.nextInt();
        }

        Arrays.sort(nArr);

        while (startIdx < endIdx) {
            int sum = nArr[startIdx] + nArr[endIdx];
            if (sum > M) {
                endIdx--;
            } else if (sum < M) {
                startIdx++;
            } else {
                count++;
                startIdx++;
                endIdx--;
            }
        }

        System.out.println(count);
    }
}
