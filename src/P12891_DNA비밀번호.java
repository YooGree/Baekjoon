import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
public class P12891_DNA비밀번호 {
    static int checkCount;
    static int[] checkArr;
    static int[] myArr;

    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bfr.readLine());

        int S = Integer.parseInt(stz.nextToken()); // DNA 문자열 길이
        int P = Integer.parseInt(stz.nextToken()); // 비밀번호로 사용할 부분문자열 길이
        int resultCount = 0;
        checkCount = 0;
        checkArr = new int[4];
        myArr = new int[4];

        stz = new StringTokenizer(bfr.readLine());

        char[] cArr = stz.nextToken().toCharArray(); // DNA 문자 배열

        stz = new StringTokenizer(bfr.readLine());

        // DNA 문자열의 각 문자별 최소 횟수 저장
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(stz.nextToken());
            if (checkArr[i] == 0)
                checkCount++;
        }

        for (int i = 0; i < P; i++) {
            AddMyArr(cArr[i]);
        }

        if (checkCount == 4) resultCount++;

        // 슬라이딩 윈도우
        for (int i = P; i < S; i++) {
            int j = i - P;
            AddMyArr(cArr[i]);
            RemoveMyArr(cArr[j]);
            if (checkCount == 4) resultCount++;
        }

        System.out.println(resultCount);
        bfr.close();
    }

    private static void AddMyArr(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) checkCount++;
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) checkCount++;
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) checkCount++;
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) checkCount++;
                break;
        }
    }

    private static void RemoveMyArr(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) checkCount--;
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) checkCount--;
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) checkCount--;
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) checkCount--;
                myArr[3]--;
                break;
        }
    }
}
