import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P8595_히든넘버 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String line = br.readLine();
        //나온 숫자들을 더한 값.
        long total = 0;
        //연속해서 나오는 숫자를 저자하기 위한 임시 문자열.
        String temp = "0";
        for(int i=0; i<N; i++){
            char target = line.charAt(i);
            //0~9의 숫자를 구분하기 위해 아스키코드 사용.
            if(target >= 48 && target <= 57){
                temp += String.valueOf(target);
            } else{
                total += Long.valueOf(temp);
                //NumberFormatException을 피하기 위해 "0"으로 설정.
                temp = "0";
            }
        }
        System.out.println(total + Long.valueOf(temp));
    }
}

