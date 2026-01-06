import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P3062_수뒤집기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String str = br.readLine();
            String reverse = "";
            String check = null;

            for (int j = str.length() - 1; j >= 0; j--) {
                reverse = reverse + str.charAt(j);
            }

            int sum = Integer.parseInt(str) + Integer.parseInt(reverse);
            String changeString = Integer.toString(sum);

            for (int j = 0; j < (changeString.length() / 2); j++) {
                char left = changeString.charAt(j);
                char right = changeString.charAt(changeString.length() - j - 1);

                if (left != right){
                    check = "PASS";
                    break;
                }
            }

            if (check == null){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
