import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P17362_수학은체육과목입니다2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 8 == 0) {
            System.out.println(2);
        }else if(N % 4 == 3) {
            System.out.println(3);
        }else if(N % 8 == 6) {
            System.out.println(4);
        }else {
            System.out.println(N % 8);
        }
    }
}
