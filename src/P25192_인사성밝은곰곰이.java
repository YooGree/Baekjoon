import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class P25192_인사성밝은곰곰이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                // 새로운 사람 입장 플래그
                set.clear();
                continue;
            }

            if (!set.contains(str)) {
                set.add(str);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
