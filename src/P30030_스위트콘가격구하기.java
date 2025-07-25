import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class P30030_스위트콘가격구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int B = Integer.parseInt(br.readLine());

        DecimalFormat df = new DecimalFormat("#.##");
        String formattedNumber = df.format(B / 1.1);
        System.out.println(formattedNumber);
    }
}
