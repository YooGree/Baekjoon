import java.util.Scanner;

public class P2440_별찍기3 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();

        for(int i=0; i<num; i++) {

            for(int j=i+1; j<=num; j++) {

                System.out.print("*");
            }
            System.out.println();
        }
    }
}
