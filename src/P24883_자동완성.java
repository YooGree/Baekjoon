import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24883_자동완성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(br.readLine().toLowerCase().charAt(0) == 'n' ? "Naver D2" : "Naver Whale");
    }
}
