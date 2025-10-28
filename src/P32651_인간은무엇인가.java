import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P32651_인간은무엇인가 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N < 100000 && N % 2024 == 0){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
