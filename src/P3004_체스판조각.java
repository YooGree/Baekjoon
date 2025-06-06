import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3004_체스판조각 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 1; i <= N; i++) {
            if(i == 1) {
                sum += 2;
            }else {
                sum += ((i / 2) + 1);
            }
        }
        System.out.println(sum);
    }
}
