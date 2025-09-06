import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11948_과목선택 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //총 합을 넣을 변수를 선언
        int sum = 0;
        //최솟값을 넣을 변수를 100으로 선언
        int min = 100;

        //앞 4과목 총 합을 구하고 4과목 중 최솟값을 구하는 반복문
        for(int i = 0; i < 4; i++) {
            int N = Integer.parseInt(br.readLine());
            sum += N;
            if(min > N) {
                min = N;
            }
        }
        //구한 최솟값을 합에서 뻄
        sum -= min;
        //남은 두과목 중 최솟 값을 다시 구해야하니 100으로 초기화
        min = 100;
        //남은 두과목의 합과 최솟 값을 다시 구하는 반복문
        for(int i = 0; i < 2; i++) {
            int N = Integer.parseInt(br.readLine());
            sum += N;
            if(min > N) {
                min = N;
            }
        }
        sum -= min;

        System.out.println(sum);
    }
}
