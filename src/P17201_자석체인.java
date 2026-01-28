import java.util.Scanner;

public class P17201_자석체인 {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int magnet = sc.nextInt();
        char[] magnetpolarity = sc.next().toCharArray();

        boolean isLinked = true;
        for (int i = 0; i < magnetpolarity.length - 1; i++) {
            if (magnetpolarity[i] == magnetpolarity[i + 1]) {
                isLinked = false;
            }
        }

        if (isLinked == true) System.out.print("Yes");
        else if (isLinked == false) System.out.print("No");

    }
}
