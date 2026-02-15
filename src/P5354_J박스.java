import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5354_J박스 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            //행 열을 담당 할 반복문
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    // 첫째 줄과 마지막 줄에 #이 온다.
                    if(j == 1 || j ==n) {
                        System.out.print("#");
                    }else {
                        //첫번째 칸과 마지막 칸에 #이 온다. 이외에는 J로 채움
                        if(k == 1 || k == n) {
                            System.out.print("#");
                        }else {
                            System.out.print("J");
                        }
                    }
                }
                //행을 구분하기 위한 print문
                System.out.println();
            }
            //테스트 케이스마다 라인을 공백으로 구문하기 위한 print
            System.out.println();
        }
    }
}
