import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P20492_세금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.print((int)(N - (N * 0.22)) + " "); // 전체 상금의 22%를 제세공과금으로 납부하는 경우
        System.out.println((int)(N - ((N * 0.2) * 0.22))); // 상금의 80%를 필요 경비로 인정받고, 나머지 금액 중 22%만을 제세공과금으로 납부하는 경우
    }
}
