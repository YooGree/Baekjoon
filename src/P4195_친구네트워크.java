import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4195_친구네트워크 {
    static int F; // 친구 관계의 수
    static int[] parent, rank;
    static int size = 100001;
    static Map<String, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        map = new HashMap<>();

        int testCase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCase; i++) {
            F = Integer.parseInt(br.readLine());
            parent = new int[size * 2];
            rank = new int[size * 2];

            for (int j = 1; j < size * 2; j++) {
                parent[j] = j;
                rank[j] = 1;
            }

            int idx = 1;
            for (int j = 0; j < F; j++) {
                String line = br.readLine();
                st = new StringTokenizer(line);
                for (int k = 0; k < 2; k++) {
                    String name = st.nextToken();
                    if (!map.containsKey(name)) {
                        map.put(name, idx++);
                    }
                }

                String[] network = line.split(" ");
                int people1 = map.get(network[0]);
                int people2 = map.get(network[1]);
                int num = union(people1, people2);
                sb.append(num + "\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int find(int v) {
        if (parent[v] == v) return v;
        else return parent[v] = find(parent[v]);
    }

    public static int union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            if (x > y) {
                parent[x] = y;
                rank[y] += rank[x];
                return rank[y];
            } else {
                parent[y] = x;
                rank[x] += rank[y];
                return rank[x];
            }
        }
        return rank[x];
    }
}
