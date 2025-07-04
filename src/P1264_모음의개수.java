import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1264_모음의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //무한루프
        while(true) {
            //입력받을 값을 대문자로 바꿔 저장.
            String S = br.readLine().toUpperCase();

            //# 입력시 무한루프 종료
            if(S.equals("#")) break;

            //5가지의 모음을 지워서 result에 저장.(한줄로 하면 길어지니 한줄에 하나씩 지워줌)
            String result = S.replace("A", "")
                    .replace("E", "")
                    .replace("I", "")
                    .replace("O", "")
                    .replace("U", "");

            //두 문자열 길이의 차를 출력
            System.out.println(S.length() - result.length());
        }
    }
}
