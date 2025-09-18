import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P30676_이별은무슨색일까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());

        if (A >= 620 && A <= 780) {
            System.out.println("Red");
        } else if (A >= 590 && A < 620) {
            System.out.println("Orange");
        } else if (A >= 570 && A < 590) {
            System.out.println("Yellow");
        } else if (A >= 495 && A < 570) {
            System.out.println("Green");
        } else if (A >= 450 && A < 495) {
            System.out.println("Blue");
        } else if (A >= 425 && A < 450) {
            System.out.println("Indigo");
        } else if (A >= 380 && A < 425) {
            System.out.println("Violet");
        }
    }
}
