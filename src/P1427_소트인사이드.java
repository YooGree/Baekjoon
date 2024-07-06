import java.util.Scanner;

public class P1427_소트인사이드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] numChar = sc.next().toCharArray();

        // 선택정렬
        for (int i = 0; i < numChar.length; i++) {
            char max = '0';
            for (int j = i; j < numChar.length; j++) {
                if (max < numChar[j]) {
                    max = numChar[j];

                    char temp = numChar[i];
                    numChar[i] = numChar[j];
                    numChar[j] = temp;
                }
            }
            System.out.print(numChar[i]);
        }
    }
}
