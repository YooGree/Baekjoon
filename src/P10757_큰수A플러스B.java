import java.math.BigInteger;
import java.util.Scanner;

public class P10757_큰수A플러스B {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        BigInteger A = new BigInteger(in.next());
        BigInteger B = new BigInteger(in.next());

        A = A.add(B);

        System.out.println(A.toString());
    }
}
