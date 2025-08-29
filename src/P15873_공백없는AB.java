import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P15873_공백없는AB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        if (str.charAt(1) == '0') {
            System.out.println(10 + Integer.parseInt(str.substring(2)));
        } else {
            System.out.println(Character.getNumericValue(str.charAt(0)) + Integer.parseInt(str.substring(1)));
        }

    }
}
