import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2741_N찍기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(i + 1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
