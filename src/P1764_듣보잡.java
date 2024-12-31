import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class P1764_듣보잡 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<String> inSet = new HashSet<>();
        Set<String> resultSet = new TreeSet<>(); // 기본적으로 오름차순 정렬을 지원

        for (int i = 0; i < N; i++) {
            inSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String name = br.readLine();
            if (inSet.contains(name)) {
                resultSet.add(name);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String name : resultSet) {
            sb.append(name + '\n');
        }

        System.out.println(resultSet.size());
        System.out.println(sb);

    }
}
