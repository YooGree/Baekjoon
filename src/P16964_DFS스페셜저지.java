import java.io.*;
import java.util.*;

public class P16964_DFS스페셜저지 {
    static int N;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();	// 그래프 저장 리스트
    static Queue<Integer> result = new LinkedList<Integer>(); // 입력된 순서 저장 큐
    static boolean[] visited; // 정점 방문 여부 확인 배열
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        for (int i = 0; i <= N; i++)
            graph.add(new ArrayList<>());

        for (int i = 0; i <N - 1; i++) {
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        st = new StringTokenizer(br.readLine()," ");
        for (int i = 0; i < N; i++)
            result.add(Integer.parseInt(st.nextToken()));

        int first = result.poll(); // 입력된 순서에 시작 정점 추출
        if (first != 1) // 시작 정점 1이 아닌 경우
            bw.write("0");
        else {
            if(dfs(1, 0)) // DFS 탐색 가능시
                bw.write("1");
            else // DFS 탐색 불가능시
                bw.write("0");
        }

        bw.flush();
        bw.close();
        br.close();
    }
    // 입력된 순서로 DFS 탐색 가능한지 확인하는 함수
    static boolean dfs(int cur, int parent) {
        if (visited[cur])
            return true;

        int size = graph.get(cur).size();
        visited[cur] = true;
        HashSet<Integer> set = new HashSet<>();
        // 인접한 정점 HashSet 저장
        for (int next : graph.get(cur)) {
            if(next!= parent)
                set.add(next);
        }
        // 입력한 순서로 HashSet 비교 및 DFS 탐색 진행
        while (!set.isEmpty()) {
            int temp = result.poll();
            if (set.contains(temp)) {
                set.remove(temp);
                if (!dfs(temp, cur))
                    return false;
            } else
                return false;
        }
        return true;
    }
}
