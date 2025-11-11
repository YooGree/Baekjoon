import java.util.Scanner;

public class P1773_폭죽쇼 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int c = sc.nextInt();
        int[] sequence = new int[n];

        for(int i=0; i<n; i++){
            sequence[i]= sc.nextInt();
        }

        int result = calculateResult(n, c, sequence);
        System.out.println(result);
    }

    private static int calculateResult(int n, int c, int[] sequence){
        int count=0;

        for(int i=1; i<=c;i++){ //쇼가 끝나기 전까지
            for(int j=0;j<n;j++){ //주기 중 하나라도
                if(i%sequence[j]==0){ //터지면
                    count++; //세고
                    break; //다른 주기는 체크하지 않는다
                }
            }
        }
        return count;
    }
}
