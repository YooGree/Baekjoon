import java.util.Scanner;

public class P33964_레퓨닛의덧셈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();

        // X자리와 Y자리의 레퓨닛을 문자열로 생성
        String repunitX = "1".repeat(X);
        String repunitY = "1".repeat(Y);

        // 문자열을 정수로 변환하고 합산
        int numX = Integer.parseInt(repunitX);
        int numY = Integer.parseInt(repunitY);
        int sum = numX + numY;

        // 결과 출력
        System.out.println(sum);
    }
}
