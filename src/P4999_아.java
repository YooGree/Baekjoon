import java.util.Scanner;

public class P4999_아 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        sc.close();
        if (str1.length() >= str2.length()){
            System.out.println("go");
        } else {
            System.out.println("no");
        }
    }
}
