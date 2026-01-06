import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1718_암호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();

        String A = br.readLine();
        String B = br.readLine();

        int bIdx = 0;
        for(int i = 0; i < A.length(); i++){
            int a = A.charAt(i) - 'a';
            int b = B.charAt(bIdx) - 'a' + 1;

            if(A.charAt(i) == ' ') {
                str.append(" ");
            }else{
                str.append((char)((26 + a - b)%26 + 'a') + "");
            }
            bIdx++;
            bIdx = bIdx % B.length();
        }

        System.out.print(str);
        br.close();
    }
}
