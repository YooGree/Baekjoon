import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1032_명령프롬프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        int len = arr[0].length();
        for (int i = 0; i < len; i++) {
            boolean b = true;  //모든 파일의 i번째 단어가 같으면 true, 다르면 false
            char c = arr[0].charAt(i);  //첫 파일의 i번째 단어
            for (int j = 1; j < n; j++) {
                if (c != arr[j].charAt(i)) b = false;  //파일의 단어가 다르면 false로 바꿔주기
            }
            if (b) {
                sb.append(c);  //모든 파일의 단어가 같으면 그 단어 출력
            } else {
                sb.append("?");  //다르면 ? 출력
            }
        }
        System.out.print(sb);
    }
}
