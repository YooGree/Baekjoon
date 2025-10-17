import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P23803_골뱅이찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 4*n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append('@');
            }
            sb.append('\n');
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5*n; j++) {
                sb.append('@');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
