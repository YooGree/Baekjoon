import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15727_조별과제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        int ans = 0;

        if (L % 5 == 0) ans = L / 5;
        else ans = L / 5 + 1;

        System.out.println(ans);
    }
}
