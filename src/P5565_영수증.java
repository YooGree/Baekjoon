import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5565_영수증 {
    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int total;  //총 가격
        total = Integer.parseInt(br.readLine());

        // 9개의 물건들의 값을 총 가격에서 빼준다
        for (int i = 1; i <= 9; i++) {
            total -= Integer.parseInt(br.readLine());
        }
        System.out.print(total);
    }
}
