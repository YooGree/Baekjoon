import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class P24479_깊이우선탐색1 {
    static int N; // 정점의 수
    static int M; // 간선의 수
    static int R; // 시작정점
    static ArrayList<ArrayList<Integer>> A; // 인접 리스트
    static int[] visited; // 방문 체크 배열 (방문 순서를 저장해야하기 떄문에 Intger로 선언)
    static int count; // 방문순서
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        R = sc.nextInt();
        visited = new int[N + 1];
        A = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            A.add(new ArrayList<>());
        }

        // 무방향 그래프 정보 입력
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            A.get(start).add(end);
            A.get(end).add(start);
        }

        // 오름차순을 위해 정렬
        for (int i = 0; i < A.size(); i++) {
            Collections.sort(A.get(i));
        }

        count = 1;
        DFS(R);

        for (int i = 1; i < visited.length; i++) {
            System.out.println(visited[i]);
        }
    }

    public static void DFS(int start) {
        visited[start] = count;
        // 현재 정점이 갈 수 있는 인접 정점 리스트 조회
        for (int i = 0; i < A.get(start).size(); i++) {
            int newStart = A.get(start).get(i);
            // 다음 갈 정점을 방문했는지 체크
            if (visited[newStart] == 0) {
                count++;
                DFS(newStart);
            }
        }

    }
}
