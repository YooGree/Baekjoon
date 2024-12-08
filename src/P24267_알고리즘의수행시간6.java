import java.io.*;

public class P24267_알고리즘의수행시간6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        br.close();

        bw.write((n*(n-1)*(n-2)/6)+"\n" + 3);
        bw.flush();
        bw.close();
    }
}
