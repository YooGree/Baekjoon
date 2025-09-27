import java.util.Scanner;

public class P28691_정보보호학부동아리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        if (name.equals("M")) {
            System.out.println("MatKor");
        } else if (name.equals("W")) {
            System.out.println("WiCys");
        } else if (name.equals("C")) {
            System.out.println("CyKor");
        } else if (name.equals("A")) {
            System.out.println("AlKor");
        } else {
            System.out.println("$clear");
        }
    }
}
