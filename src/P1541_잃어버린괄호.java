import java.io.IOException;
import java.util.Scanner;

public class P1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] sikArr = sc.nextLine().split("-");
        int totalSum = 0;

        for (int i = 0; i < sikArr.length; i++) {
            if (i == 0) totalSum += sum(sikArr[i]);
            else {
                totalSum -= sum(sikArr[i]);
            }
        }

        System.out.println(totalSum);
    }

    private static int sum (String sik) {
        int returnValue = 0;
        String[] sumSikArr = sik.split("\\+");

        for (String val : sumSikArr) {
            returnValue += Integer.parseInt(val);
        }

        return returnValue;
    }
}
