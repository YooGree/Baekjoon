import java.io.*;
import java.util.StringTokenizer;

public class P2858_기숙사바닥 {
    public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(s.nextToken());
        int b = Integer.parseInt(s.nextToken());

        for (int l = 3; l <= r; l++) {
            for (int w = 3; w <= l; w++) {
                if(l*2+(w-2)*2 == r && (l-2)*(w-2)==b){
                    bw.write(l+" "+w);
                    break;
                }
            }
        }

        bw.close();
    }
}
