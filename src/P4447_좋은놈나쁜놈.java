import java.util.Scanner;

public class P4447_좋은놈나쁜놈 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < N; i++) {
            String str = scan.nextLine();
            int g = 0;
            int b = 0;
            String dummy = str.replace(" ", "").toLowerCase();
            for (int j = 0; j < dummy.length(); j++) {
                if (dummy.charAt(j) == 'g')
                    ++g;
                else if (dummy.charAt(j) == 'b')
                    ++b;
            }
            String ret = " is ";
            if (g > b)
                ret += "GOOD";
            else if (g < b)
                ret += "A BADDY";
            else
                ret += "NEUTRAL";

            System.out.println(str + ret);
        }

        scan.close();
    }
}
