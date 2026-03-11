import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P9437_사라진페이지찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            //0하나만 입력하면 종료하라고 했기때문에 첫번째 입력되었을때 종료 여부 파악.
            if(N == 0) break;

            int P = Integer.parseInt(st.nextToken());

            int[] arr = new int[3];

            if(P % 2 == 0) {
                arr[0] = (P - 1);
                arr[1] = (N - (P - 1));
                arr[2] = (N - (P - 2));
            }else {
                arr[0] = (P + 1);
                arr[1] = (N - P);
                arr[2] = (N - (P - 1));
            }

            Arrays.sort(arr);

            System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
        }
    }
}
