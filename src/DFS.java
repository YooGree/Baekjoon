import java.util.ArrayList;
import java.util.Stack;

public class DFS {
    public static void main(String[] args) {
        ArrayList<Integer>[] graph = new ArrayList[10];
        boolean[] visited = new boolean[10];
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        // 1. 인접리스트 초기화
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
            visited[i] = false; // 초기화 안해줘도 선언할떄 기본값으로 false로 들어감
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[1].add(8);
        graph[2].add(1);
        graph[2].add(7);
        graph[3].add(1);
        graph[3].add(4);
        graph[3].add(5);
        graph[4].add(3);
        graph[4].add(5);
        graph[5].add(3);
        graph[5].add(4);
        graph[6].add(7);
        graph[7].add(2);
        graph[7].add(6);
        graph[7].add(8);
        graph[8].add(1);
        graph[8].add(7);
        
        // 2. DFS 메서드 구현
        stack.push(1); // 시작 노드를 스택애 넣어준다.
        visited[1] = true; // 시작 노드를 방문처리한다.
        while (!stack.isEmpty()) {
            int nodeIndex = stack.pop(); // 스택에서 하나를 꺼낸다.
            result.add(nodeIndex); // 방문 노드 저장
            for (int linkNode : graph[nodeIndex]) {
                // 꺼낸 노드의 인접한 노드를 탐색하면서 방문하지 않았을 경우 스택에 넣고 방문처리
                if (!visited[linkNode]) {
                    stack.push(linkNode);
                    visited[linkNode] = true;
                }
            }
        }
        
        // 3. 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(result.get(i) + " ");
        }
        System.out.println(sb.toString());
    }
}
