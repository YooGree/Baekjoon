import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P31403_ABC {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());
        String s = "";
        s += a;
        s += b;

        System.out.println(a + b - c);
        System.out.println(Integer.parseInt(s) - c);
    }
}
