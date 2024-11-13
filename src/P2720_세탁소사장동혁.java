import java.util.Scanner;

public class P2720_세탁소사장동혁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int quarter = 25;
        int dime = 10;
        int nickel = 5;
        int penny = 1;
        int quarterCnt;
        int dimeCnt;
        int nickelCnt;
        int pennyCnt;

        for (int i = 0; i < T; i++) {
            int C = sc.nextInt();
            int cost;

            quarterCnt =  C / quarter;
            cost =  C % quarter;

            dimeCnt = cost / dime;
            cost =  cost % dime;

            nickelCnt = cost / nickel;
            cost =  cost % nickel;

            pennyCnt = cost / penny;
            cost = cost % penny;

            System.out.println(quarterCnt + " " + dimeCnt + " " + nickelCnt + " " + pennyCnt);
        }
    }
}
