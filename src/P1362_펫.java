import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1362_펫 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //시나리오 값
        int num = 1;

        //무한루프
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int o = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            //0 0 입력 시 무한루프 종료
            if(o == 0 && w == 0) break;

            //펫의 사망 여부를 확인하기위한 변수
            int count = 0;

            //무한루프
            while(true) {
                st = new StringTokenizer(br.readLine());
                String EF = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                //# 0 입력 시 무한루프 종료
                if(EF.equals("#") && n == 0) break;

                if(EF.equals("E")) w -= n;
                if(EF.equals("F")) w += n;

                //사망했으면 count에 1 저장.
                if(w <= 0) {
                    count = 1;
                }
            }
            //count가 1이면 펫은 죽었으니 RIP 출력
            if(count == 1){
                System.out.println(num + " RIP");
            }else {
                if((o / 2) < w && w < (o * 2)) {
                    System.out.println(num + " :-)");
                }else {
                    System.out.println(num + " :-(");
                }
            }
            //첫 무한루프문이 반복될때마다 시나리오 값이 1증가
            num++;
        }

    }
}
