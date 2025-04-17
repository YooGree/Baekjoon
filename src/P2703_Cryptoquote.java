import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2703_Cryptoquote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t,i;
        t = Integer.parseInt(br.readLine());
        while(t-->0) {
            String code = br.readLine();
            String crypto = br.readLine();
            for(i=0;i<code.length();i++) {
                if(code.charAt(i)>='A'&&code.charAt(i)<='Z') {
                    sb.append(crypto.charAt(code.charAt(i)-'A'));
                }else {
                    sb.append(code.charAt(i));
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
