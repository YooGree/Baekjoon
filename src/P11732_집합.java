import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class P11732_집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<Integer> S = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String keyword = st.nextToken();
            int num = 0;
            if (!keyword.equals("all") && !keyword.equals("empty"))
                num = Integer.parseInt(st.nextToken());

            switch (keyword) {
                case "add":
                    if (S.contains(num)) continue;
                    S.add(num);
                    break;
                case "remove":
                    if (!S.contains(num)) continue;
                    S.remove(num);
                    break;
                case "check":
                    if (S.contains(num)) sb.append(1 + "\n");
                    else sb.append(0 + "\n");
                    break;
                case "toggle":
                    if (S.contains(num)) S.remove(num);
                    else S.add(num);
                    break;
                case "all":
                    S.clear();
                    for (int j = 0; j < 20; j++) {
                        S.add(j + 1);
                    }
                    break;
                case "empty":
                    S.clear();
                    break;
            }
        }

        System.out.println(sb.toString());
    }
}
