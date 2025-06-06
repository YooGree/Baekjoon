import java.io.*;
import java.util.StringTokenizer;

public class P19941_햄버거분배 {
    static char[] info;	//식탁 정보 저장 배열
    static int answer = 0;	//먹은 인원수 저장 변수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        info = br.readLine().toCharArray();		//식탁 정보 배열 형태로 저장
        //식탁 정보 탐색
        for(int i=0;i<N;i++){
            if(info[i] == 'P'){		//사람일 때 먹을 수있는 햄버거 탐색
                int index = Math.max(i - K, 0);
                boolean check = false;
                //먹을 수 있는 햄버거 왼쪽 범위 탐색
                //가장 먼저 발견한 햄버거가 범위 왼쪽에 가장 가까운 햄버거!
                for(int j=index;j<i;j++){
                    if(bergerCheck(j)){	//먹을 수 있는 햄버거 발견
                        check = true;
                        break;
                    }
                }
                //먹을 수 있는 햄버거 오른쪽 범위 탐색
                if(!check){
                    index = i + K >= N ? N-1 : i + K;
                    for(int j=i+1;j<=index;j++){
                        if(bergerCheck(j))	//먹을 수 있는 햄버거 발견
                            break;
                    }
                }
            }
        }
        bw.write(answer + "");	//햄버거 먹은 인원수 BufferedWriter 저장
        bw.flush();		//결과 출력
        bw.close();
        br.close();
    }
    //범위 탐색할 때 먹을 수 있는 햄버거인지 확인하는 함수
    static boolean bergerCheck(int index){
        if(info[index] == 'H'){		//햄버거가 맞을 때
            info[index] = 'X';	//햄버거 먹었기 때문에 'X'로 변경
            answer++;		//먹은 인원수 증가!
            return true;	//먹기 성공 True
        }
        return false;		//먹기 실패 False
    }
}
