import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3449_해밍거리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. 테스트 케이스의 개수 T를 입력받습니다.
        // String을 int로 변환할 때는 Integer.parseInt()를 사용합니다.
        int T = Integer.parseInt(br.readLine());

        // 2. T만큼 반복하며 각 테스트 케이스를 처리합니다.
        for(int t = 0; t < T; t++) {
            // 2-1. 첫 번째 이진수를 문자열로 입력받습니다.
            String binary1 = br.readLine();
            // 2-2. 두 번째 이진수를 문자열로 입력받습니다.
            String binary2 = br.readLine();

            // 2-3. 해밍 거리를 저장할 변수를 초기화합니다.
            int hammingDistance = 0;

            // 2-4. 두 이진수의 길이는 같으므로, 첫 번째 이진수의 길이를 기준으로 반복합니다.
            // 각 자리의 문자를 비교하며 다르면 해밍 거리를 1 증가시킵니다.
            for(int i = 0; i < binary1.length(); i++) {
                if(binary1.charAt(i) != binary2.charAt(i)) {
                    hammingDistance++;
                }
            }

            // 2-5. 계산된 해밍 거리를 문제에서 요구하는 형식에 맞춰 출력합니다.
            System.out.println("Hamming distance is " + hammingDistance + ".");
        }

        // 3. 모든 입력을 읽었으므로 BufferedReader를 닫아줍니다.
        br.close();
    }
}
