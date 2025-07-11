import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P32951_AI선도대학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(N - 2024);
    }
}
