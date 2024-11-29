import java.util.Scanner;

public class P10101_삼각형외우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int angle_1 = sc.nextInt();
        int angle_2 = sc.nextInt();
        int angle_3 = sc.nextInt();

        if (angle_1 == 60 && angle_2 == 60 && angle_3 == 60) {
            System.out.println("Equilateral");
        } else if (angle_1 + angle_2 + angle_3 == 180) {
            if (angle_1 == angle_2 || angle_1 == angle_3 || angle_2 == angle_3) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        } else {
            System.out.println("Error");
        }
    }
}
