import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P17389_보너스점수 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String line = br.readLine();
        boolean chk = false;
        int sum = 0;
        int bonus = 0;
        for (int i = 0; i< N; i++) {
            char c = line.charAt(i);
            if(!chk){
                if(c == 'X'){
                    sum += 0;
                    bonus = 0;
                    chk = false;
                } else if(c == 'O'){
                    sum += i + 1;
                    bonus++;
                    chk = true;
                }
            } else{
                if(c == 'X'){
                    chk = false;
                    sum += 0;
                    bonus = 0;
                } else if(c == 'O'){
                    sum += i + 1 + bonus;
                    bonus++;
                    chk = true;
                }
            }
        }
        bw.write(sum + "\n");

        bw.flush();
        br.close();
        bw.close();
    }
}
