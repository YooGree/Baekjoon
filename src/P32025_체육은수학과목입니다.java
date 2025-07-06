import java.io.*;

public class P32025_체육은수학과목입니다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        int result = 0;

        if (h < w) {
            result = h * 50;
        } else {
            result = w * 50;
        }

        bw.write(Integer.toString(result));
        bw.flush();
        bw.close();
        br.close();
    }
}
