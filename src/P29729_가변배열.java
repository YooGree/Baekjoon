import java.io.*;
import java.util.StringTokenizer;

public class P29729_가변배열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int s=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken());
        int now=0;
        for(int i=0; i<n; i++){
            int temp=Integer.parseInt(br.readLine());
            if(temp==1){
                now++;
                if(now>s){
                    s*=2;
                }
            }
            else{
                now--;
            }
        }
        bw.write(s+"");
        bw.flush();


    }
}
