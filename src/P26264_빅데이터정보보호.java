import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P26264_빅데이터정보보호 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int bigDataCount = 0;
        int securityCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("s")){
                securityCount++;
            } else if (str.substring(i, i + 1).equals("b")) {
                bigDataCount++;
            }
        }

        if (bigDataCount > securityCount){
            sb.append("bigdata?");
        }else if (bigDataCount == securityCount){
            sb.append("bigdata? security!");
        }else {
            sb.append("security!");
        }

        System.out.println(sb.toString());
    }
}
