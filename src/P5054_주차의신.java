import java.util.Arrays;
import java.util.Scanner;

public class P5054_주차의신 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n1= scanner.nextInt();

        for(int i=0;i<n1;i++){

            int n2=scanner.nextInt();
            int[] num = new int[n2];

            for(int j=0;j<n2;j++){
                num[j]=scanner.nextInt();
            }

            Arrays.sort(num);

            System.out.println((num[n2-1]-num[0])*2);
        }
    }
}
