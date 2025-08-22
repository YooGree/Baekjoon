import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15680_연세대학교 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        if (num == 0) System.out.println("YONSEI");
        else System.out.println("Leading the Way to the Future");
    }
}
