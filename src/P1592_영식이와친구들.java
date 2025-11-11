import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1592_영식이와친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 친구 수
        int m = Integer.parseInt(st.nextToken()); // M번 공 받으면 게임 끝남
        int l = Integer.parseInt(st.nextToken()); // L번째 사람에게 공 던짐

        int[] arr = new int[n + 1]; // 사람마다 공 받은 횟수 저장
        int num = 1; // 공 받은 사람 숫자
        int count = 0; // 공 던진 횟수
        while (true) {
            arr[num]++;

            if (arr[num] == m) {
                break;
            }

            if (arr[num] % 2 == 1) { //홀수일 때
                num += l;
                if (num > n) {
                    num -= n;
                }
            } else { // 짝수일 때
                num -= l;
                if (num <= 0) {
                    num += n;
                }
            }
            count++;
        }

        System.out.println(count);
    }
}
