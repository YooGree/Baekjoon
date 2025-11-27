import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5988_홀수일까짝수일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String answer = "";

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            char last = str.charAt(str.length()-1);
            int number = (int)last;

            if (number % 2 == 0){
                answer = "even";
            }else{
                answer = "odd";
            }

            sb.append(answer).append("\n");
        }

        System.out.println(sb.toString());
    }
}
