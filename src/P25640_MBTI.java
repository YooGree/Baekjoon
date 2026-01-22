import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P25640_MBTI {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String jinho = br.readLine();
        int num = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i<num; i++) {
            String friend = br.readLine();

            if (jinho.equals(friend)) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

}
