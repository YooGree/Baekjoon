import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P1544_사이클단어 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter((new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());

        List<String> list = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            String tmp1 = list.get(i);
            for (int j = i + 1; j < N; j++) {
                if (tmp1.length() == list.get(j).length()) {
                    String tmp2 = list.get(j) + list.get(j);
                    if (tmp2.contains(tmp1)) {
                        list.remove(j);
                        N--;
                        j--;
                    }
                }
            }
        }
        System.out.println(N);

        bw.flush();
        bw.close();
        br.close();
    }
}
