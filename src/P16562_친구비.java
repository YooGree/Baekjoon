import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P16562_친구비 {
    public static int N, M, K;
    public static int answer = 0;
    public static int[] parent;
    public static int[] money;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 학생 수
        M = Integer.parseInt(st.nextToken()); // 친구관계 수
        K = Integer.parseInt(st.nextToken()); // 가지고 있는 돈

        parent = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            parent[i] = i;
        }

        money = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            money[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        for (int i = 1; i <= N; i++) {
            if (find(i) == i) {
                answer += money[i];
            }
        }

        if (K < answer) System.out.println("Oh no");
        else System.out.println(answer);
    }

    static int find(int n) {
        if (parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (money[rootX] < money[rootY]) parent[rootY] = rootX;
            else parent[rootX] = rootY;
        }
    }

}
