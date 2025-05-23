import java.io.*;

public class P13909_창문닫기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int count = 0; //창문이 열려있는 개수
        for(int i = 1; i * i <= N; i++) { //제곱수만 카운트
            count++;
        }

        bw.write(count + "\n");

        br.close();

        bw.flush();
        bw.close();
    }
}
