import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P11094_꿍가라시대 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String answer = "";
            String str = br.readLine();

            if (str.contains("Simon says")){
                answer = str.substring(10);
            }else{
                continue;
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb.toString());
    }
}
