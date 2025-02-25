import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P5073_삼각형과세변 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = new int[3];

        while (true) {
            st = new StringTokenizer(br.readLine());
            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[1] == 0 && arr[2] == 0) {
                break;
            }

            // 오름차순으로 정렬
            Arrays.sort(arr);

            if(arr[2] >= arr[0] + arr[1]) {
                System.out.println("Invalid");
            } else if(arr[0] == arr[1] && arr[1] == arr[2]) {
                System.out.println("Equilateral");
            } else if(arr[0] == arr[1] || arr[1] == arr[2] || arr[0] == arr[2]) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}
