import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5789_한다안한다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-->0) {
            String cur = br.readLine();
            sb.append(cur.charAt(cur.length()/2-1)==cur.charAt(cur.length()/2)?"Do-it":"Do-it-Not").append('\n');
        }
        System.out.println(sb);
    }
}
