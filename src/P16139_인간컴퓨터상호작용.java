import java.io.*;

public class P16139_인간컴퓨터상호작용 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int len = s.length();

        // 각 알파벳(26개)에 대해 누적합 배열 구성
        int[][] dp = new int[26][len + 1];

        // 누적 합 초기화 (1-based index)
        for (int i = 0; i < len; i++) {
            int charIndex = s.charAt(i) - 'a'; // 해당 문자의 인덱스
            for (int j = 0; j < 26; j++) {
                dp[j][i + 1] = dp[j][i] + (j == charIndex ? 1 : 0);
            }
        }

        // 쿼리 처리
        for (int i = 0; i < N; i++) {
            String[] query = br.readLine().split(" ");
            int targetChar = query[0].charAt(0) - 'a';
            int startIndex = Integer.parseInt(query[1]);
            int endIndex = Integer.parseInt(query[2]);

            // 해당 문자의 출현 횟수 = dp[targetChar][end+1] - dp[targetChar][start]
            int count = dp[targetChar][endIndex + 1] - dp[targetChar][startIndex];
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }
}
