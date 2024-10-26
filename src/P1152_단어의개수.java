import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1152_단어의개수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] strArr = br.readLine().split(" ");
        int sum = 0;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] != "" && strArr[i] != null) {
                ++sum;
            }
        }

        System.out.println(sum);
    }
}
