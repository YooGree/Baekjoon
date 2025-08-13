import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P34071_첫번째문제는과연쉬운문제일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int firstNum = -1;
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if (firstNum == -1) firstNum = num;
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        if (firstNum == min) {
            System.out.println("ez");
        } else if (firstNum == max) {
            System.out.println("hard");
        } else {
            System.out.println("?");
        }

    }
}
