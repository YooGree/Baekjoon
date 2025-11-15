import java.io.*;
import java.util.StringTokenizer;

public class P14720_우유축제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int milk = 0;
        int answer = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<N;i++){
            int n = Integer.parseInt(st.nextToken());
            if(milk == n){
                milk = milk + 1 == 3 ? 0 : milk + 1;
                answer++;	//우유 먹은 횟수 증가
            }
        }
        bw.write(answer +"");
        bw.flush();
        bw.close();
        br.close();

    }
}
