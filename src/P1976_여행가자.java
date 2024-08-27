import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1976_여행가자 {
    static int N; // 도시의 수
    static int M; // 여행을 계획한 도시의 수
    static int[] rootParent; // 유니온 파인드 연산을 위한 조상노드 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        rootParent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            rootParent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                // 연결되어 있다면 합집합으로 연산
                if (temp == 1) {
                    union(i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        int start = find(Integer.parseInt(st.nextToken()));
        for (int i = 1; i < M; i++) {
            int now = Integer.parseInt(st.nextToken());
            // 맨 처음 출발 도시와 연결되어 있지 않은 도시가 있으면 여행이 불가능하다.
            if (start != find(now)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // value의 부모를 찾기
    public static int find(int value) {
        if (value == rootParent[value]) return value;
        else return rootParent[value] = find(rootParent[value]);
    }

    // 더 작은쪽으로 부모를 치환
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x < y) {
                rootParent[y] = x;
            } else {
                rootParent[x] = y;
            }
        }
    }
}
