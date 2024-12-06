import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P24265_알고리즘의수행시간4 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String num = bf.readLine();
        long intNum = Integer.parseInt(num);
        bf.close();

        System.out.println(intNum * (intNum - 1) / 2);
        System.out.println(2);
    }
}
