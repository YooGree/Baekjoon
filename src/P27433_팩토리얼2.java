import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27433_팩토리얼2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        br.close();
        System.out.println(factorial(N));
    }


    static long factorial(int n){
        if (n <= 0){
            return 1;
        }

        return n*factorial(n-1);
    }
}
