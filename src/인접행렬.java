import java.util.Random;

public class 인접행렬 {
    public static void main(String[] args) {
        int N = 5; // 그래프 정점의 개수
        int[][] graph = new int[N + 1][N + 1]; // Index를 1부터 맞추기 위해 N + 1
        Random random = new Random();

        // 1. 가중치가 없는 인접행렬
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                graph[i][j] = random.nextInt(2); // 0 ~ 1까지의 랜덤숫자 생성
            }
        }

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        // 2. 가중치가 있는 인접행렬
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                graph[i][j] = random.nextInt(9) + 1; // 1 ~ 9까지의 랜덤숫자 생성
            }
        }

        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph[i].length; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

}
