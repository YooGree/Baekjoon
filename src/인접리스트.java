import java.util.ArrayList;
import java.util.Random;

public class 인접리스트 {
    public static void main(String[] args) {
        int N = 5; // 그래프 정점의 개수
        int M = 5; // 그래프 간선의 개수
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>(); // ArrayList 형식의 인접리스트
        Random random = new Random();
    
        // 1. 가중치가 없는 인접리스트
        for (int i = 0; i < N + 1 ; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N) + 1;
            int b = random.nextInt(N) + 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 1; i < graph.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            for (int j = 0; j < graph.get(i).size(); j++) {
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
        System.out.println();

        // 2. 가중치가 있는 인접리스트
        ArrayList<ArrayList<Node>> graph2 = new ArrayList<>();
        for (int i = 0; i < N + 1 ; i++) {
            graph2.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int a = random.nextInt(N) + 1;
            int b = random.nextInt(N) + 1;
            int cost = random.nextInt(9) + 1;
            graph2.get(a).add(new Node(b, cost));
        }

        for (int i = 1; i < graph2.size(); i++) {
            System.out.print("정점 " + i + "의 인접리스트");
            for (int j = 0; j < graph2.get(i).size(); j++) {
                Node node = graph2.get(i).get(j);
                System.out.print(" -> (인접노드 : " + node.v + " / 가중치 : " + node.cost + ")");
            }
            System.out.println();
        }
    }
}

class Node {
    public int v;
    public int cost;
    public Node(int v, int cost) {
        super();
        this.v = v;
        this.cost = cost;
    }
}