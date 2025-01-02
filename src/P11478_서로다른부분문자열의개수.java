import java.io.*;
import java.util.HashSet;

public class P11478_서로다른부분문자열의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine(); //문자열
        br.close();

        HashSet<String> partS = new HashSet<String>(); //부분 문자열 중복 없이 넣기

        for(int i = 0; i < S.length(); i++) { //문자열의 크기로 쪼개서 각각의 자리 문자를 넣는다
            for(int j = i+1; j <= S.length(); j++){ //연속된 숫자이므로 i+1부터 시작해야한다. 다음 문자열부터 시각해야하니까
                partS.add(S.substring(i, j));
                /*
                    예를 들면, S가 abca이라고 가정하고
                    i = 0
                    j = 1 ~ 3까지 반복

                        j = 1
                        처음에는 S.subString(0, 1)이니까 0 인덱스부터 1 인덱스전까지의 문자열을 넣는다.
                        => a

                        i = 0
                        j = 2
                        S.subString(0, 2)이니까 0 인덱스부터 2 인덱스전까지의 문자열을 넣는다.
                        => ab
                   이런식으로 반복하여 구한다.
                 */
            }
        }

        //이미 중복을 제거했으니 partS의 사이즈를 출력하면 된다.
        bw.write(partS.size() + "");
        bw.flush();
        bw.close();
    }
}
