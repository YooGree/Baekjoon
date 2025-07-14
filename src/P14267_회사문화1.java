import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P14267_회사문화1 {
    static List<Integer>[] parent;
    static int[] score;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 회사의 직원 수
        int m = Integer.parseInt(st.nextToken()); // 칭찬의 횟수
        parent = new ArrayList[n + 1]; // 부모 정의 리스트
        for (int i = 1; i <= n; i++) {
            parent[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num != -1) {
                parent[num].add(i);
            }
        }

        score = new int[n + 1]; // 자식 합산 점수 배열
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int empNo = Integer.parseInt(st.nextToken()); // 칭찬 받은 직원 번호
            int w = Integer.parseInt(st.nextToken()); // 칭찬의 수치
            score[empNo] += w;
        }
        dfs(1);

        for (int i = 1; i < n + 1; i++) {
            System.out.print(score[i]+" ");
        }
    }

    private static void dfs(int empNo) {
        for (int next : parent[empNo])  {
            score[next] += score[empNo];
            dfs(next);
        }


    }
}
