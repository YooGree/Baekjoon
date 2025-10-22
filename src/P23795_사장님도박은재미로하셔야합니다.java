import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P23795_사장님도박은재미로하셔야합니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        while (true) {
            int cur = Integer.parseInt(br.readLine());
            if (cur == -1) break;
            sum+=cur;
        }
        System.out.println(sum);
    }
}
