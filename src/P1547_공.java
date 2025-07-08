import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class P1547_공 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        ArrayList<String> list = new ArrayList<String>();

        list.add("O");
        list.add("X");
        list.add("X");

        for(int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());

            Collections.swap(list, (X - 1), (Y - 1));
        }

        int count = 0;

        for(String S : list) {
            count++;

            if(S == "O"){
                break;
            }
        }

        if(count == 0) {
            System.out.println(-1);
        }else {
            System.out.println(count);
        }
    }
}
