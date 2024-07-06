import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {
    static boolean[] visited;
    static ArrayList<Integer>[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(bfr.readLine());

        int N = Integer.parseInt(stz.nextToken());
        int M = Integer.parseInt(stz.nextToken());

        visited = new boolean[N + 1];
        A = new ArrayList[N + 1];

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(bfr.readLine());

            int startPoint = Integer.parseInt(stz.nextToken());
            int endPoint = Integer.parseInt(stz.nextToken());

            A[startPoint].add(endPoint);
            A[endPoint].add(startPoint);
        }

        int count = 0;

        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                count++;
                DFS(i);
            }
        }

        System.out.println(count);
    }

    private static void DFS (int v) {
        if (visited[v]) return;
        visited[v] = true;
        for (int i : A[v]) {
            if (!visited[i]) {
                DFS(i);
            }
        }

    }
}
