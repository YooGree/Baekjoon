import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P17179_케이크자르기 {
    public static void main(String [] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int l = scan.nextInt();
        int[] cakes = new int[m+1];//마지막 케익 길이까지 받기위해서 +1
        for(int i=0;i<m;i++){
            cakes[i] = scan.nextInt();
        }
        cakes[m] = l;
        //n번 자르는 횟수 확인

        for(int i = 0 ; i<n;i++){
            int answer = 0;
            int q = scan.nextInt();  //자르는 횟수
            int low = 0;
            int high = l;
            while(low<=high) {
                int mid = (low+high)/2;
                if (checkCake(low, high, mid, cakes, q)) {
                    low = mid + 1;
                    answer = Math.max(mid, answer);
                } else {
                    high = mid - 1;
                }
            }
            System.out.println(answer);
        }

    }

    public static boolean checkCake(int low, int high, int mid, int[] cakes,int q){
        int prev=0;
        for(int i=0;i<cakes.length;i++){
            if(cakes[i]-prev >= mid){
                q--;
                prev = cakes[i];
            }
        }
        return q < 0 ? true : false;
    }
}
