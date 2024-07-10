import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2522_줄세우기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<ArrayList<Integer>> iList = new ArrayList<>();
        int[] indegree = new int[N + 1];

        /* 위상정렬 순서
         1. 인접리스트에 데이터를 초기화하면서 진입차수 배열에 값도 같이 초기화 해준다.
         2. 큐를 선언하여 진입차수가 0인 노드를 큐에 넣어준다.
         3. 현재 큐에서 데이터를 하나 꺼내고, 꺼낸 데이터를 결과 배열에 넣는다.
         4. 현재 데이터에 인접한 노드들을 탐색하면서 진입차수를 1개 낮춰준 후 해당 노드의 진입차수가 0이라면 큐에 넣어준다.
         5. 3 ~ 4 를 큐가 빌때까지 연산한다.
         */
        for (int i = 0; i <= N; i++) {
            iList.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            iList.get(a).add(b);
            indegree[b]++; // 진입차수 설정
        }

        Queue<Integer> queue = new LinkedList();
        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            System.out.print(now + " ");
            for (int iData : iList.get(now)) {
                indegree[iData]--;
                if (indegree[iData] == 0) {
                    queue.offer(iData);
                }
            }
        }
    }
}
