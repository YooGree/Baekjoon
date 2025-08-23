import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5585_거스름돈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        int cost = 1000 - num;
        int cnt = 0;
        int[] arr = {500, 100, 50, 10, 5, 1};

        for (int i = 0; i < arr.length; i++) {
            cnt += (cost / arr[i]);
            cost %= arr[i];
        }

        System.out.println(cnt);
    }
}
