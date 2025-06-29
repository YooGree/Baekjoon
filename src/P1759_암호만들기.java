import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1759_암호만들기 {
    static int L, C;
    static char[] code;
    static char[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        code = new char[L];
        arr = new char[C];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            char ch = st.nextToken().charAt(0);
            arr[i] = ch;
        }
        Arrays.sort(arr);

        recur(0, 0);
    }

    public static void recur(int depth, int start) {
        if (depth == L) {
            if (isValid(code)) {
                for (char c : code) {
                    System.out.print(c);
                }
                System.out.println();
            }
            return;
        }

        for (int i = start; i < C; i++) {
            code[depth] = arr[i];
            recur(depth + 1, i + 1);
        }

    }

    public static boolean isValid(char[] code) {
        int c = 0; // 자음의 수
        int v = 0; // 모음의 수
        for (int i = 0; i < code.length; i++) {
            if (code[i] == 'a' || code[i] == 'e' || code[i] == 'i' || code[i] == 'o' || code[i] == 'u') {
                v++; // 모음일 경우 v++
            } else {
                c++; // 자음일 경우 c++
            }
        }
        if (c >= 2 && v >= 1) {
            return true; // 자음 2개 이상, 모음 1개이상 일 경우 true 반환
        } else {
            return  false; // 아닐경우 false 반환
        }
    }





}
