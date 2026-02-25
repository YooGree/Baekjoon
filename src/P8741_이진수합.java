import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P8741_이진수합 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            sb.append("1");
        }

        for (int i = 1; i < num; i++) {
            sb.append("0");
        }

        System.out.println(sb.toString());
    }
}
