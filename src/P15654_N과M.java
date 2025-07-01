import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15654_N과M {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;
    static ArrayList<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 자연수의 갯수
        M = Integer.parseInt(st.nextToken()); // 순열을 만들 갯수
        visited = new boolean[10000];
        arr = new int[N];
        list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        Arrays.sort(arr);

        backTracking(0);
    }

    public static void backTracking(int depth) {
        if (depth == M) {
            for (int i = 0; i < M; i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            int num = arr[i];
            if (!visited[num]) {
                visited[num] = true;
                list.add(num);
                backTracking(depth + 1);
                list.remove(list.size() - 1);
                visited[num] = false;
            }
        }
    }
}
