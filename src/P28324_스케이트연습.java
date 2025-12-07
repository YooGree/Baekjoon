import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P28324_스케이트연습 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long result = 1;
        int pre = 1;
        for (int i = n-2; i >= 0; i--) {
            if(pre < arr[i]) {
                pre++;
            } else if(pre > arr[i]){
                pre = arr[i];
            }
            result += pre;
        }

        System.out.println(result);
    }
}
