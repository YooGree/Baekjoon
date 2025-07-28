import java.io.*;
import java.util.StringTokenizer;

public class P34073_DORO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            String str = st.nextToken();
            bw.write(str + "DORO" + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
