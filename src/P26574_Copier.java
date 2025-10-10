import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P26574_Copier {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int num =  Integer.parseInt(br.readLine());
            System.out.println(num + " " + num);
        }
    }
}
