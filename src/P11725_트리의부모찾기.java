import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {
    static int N; // 노드의 개수
    static int[] parent; // 부모 노드를 저장
    static boolean[] visited; // 방문 체크 배열
    static ArrayList<Integer>[] list; // 인접 리스트
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];
        parent = new int[N + 1];

        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }

        // 인접 리스트 생성
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
            list[end].add(start);
        }

        dfs(1);

        for (int i = 2; i < parent.length; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void dfs(int start) {
        visited[start] = true;
        for (int i = 0; i < list[start].size(); i++) {
            int linkNode = list[start].get(i);
            if (!visited[linkNode]) {
                parent[linkNode] = start; // 각 노드들의 부모값을 저장한다.
                dfs(linkNode);
            }
        }
    }
}
