import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS와BFS {
    static ArrayList<Integer>[] A;
    static boolean[] visited;
    static ArrayList<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점의 갯수
        int M = Integer.parseInt(st.nextToken()); // 간선의 갯수
        int V = Integer.parseInt(st.nextToken()); // 시작정점의 번호

        A = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i < N + 1; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int inputS = Integer.parseInt(st.nextToken());
            int inputE = Integer.parseInt(st.nextToken());

            A[inputS].add(inputE);
            A[inputE].add(inputS);
        }

        // DFS, BFS 실행하기 이전에 배열을 정렬한다.
        for (int i = 1; i < A.length; i++) {
            Collections.sort(A[i]);
        }

        // DFS 출력
        // 스택을 사용한 DFS라면 내림차순정렬
//        for (int i = 1; i < A.length; i++) {
//            Collections.sort(A[i], Collections.reverseOrder());
//        }
        DFS_Rec(V);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }

        Arrays.fill(visited, false);
        result.clear();
        System.out.println();
        
        // BFS 출력
        // 다시 오름차순
//        for (int i = 1; i < A.length; i++) {
//            Collections.sort(A[i]);
//        }
        BFS(V);
        for (int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }

    static void DFS_Rec (int start) {
        if (!visited[start]) {
            result.add(start);
            visited[start] = true;
        }
        for (int i = 0; i < A[start].size(); i++) {
            if (!visited[A[start].get(i)]) {
                DFS_Rec(A[start].get(i));
            }
        }
    }

//    static void DFS_Stack (int start) {
//        Stack<Integer> stack = new Stack<>();
//        stack.add(start);
//        while(!stack.isEmpty()) {
//            int nowNode = stack.pop();
//            if (!visited[nowNode]) {
//                result.add(nowNode);
//                visited[nowNode] = true;
//            }
//            for (int linkNode : A[nowNode]) {
//                if (!visited[linkNode]) {
//                    stack.add(linkNode);
//                }
//            }
//        }
//    }

    static void BFS (int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int nowNode = queue.poll();
            if (!visited[nowNode]) {
                result.add(nowNode);
                visited[nowNode] = true;
            }
            for (int linkNode : A[nowNode]) {
                if (!visited[linkNode]) {
                    queue.offer(linkNode);
                }
            }
        }

    }
}
