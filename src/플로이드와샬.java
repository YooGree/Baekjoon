public class 플로이드와샬 {
    static int number = 4;
    static int INF = 100000000;
    static int[][] A;
    static int[][] D;
    public static void main(String[] args) {
        // 자료 배열을 초기화
        A = new int[][] {   {0, 5, INF, 8},
                            {7, 0, 9, INF},
                            {2, INF, 0, 4},
                            {INF, INF, 3, 0}
                        };

        floydWarshall();

        // 결과를 출력
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void floydWarshall() {
        // 결과 그래프 초기화
        D = new int[number][number];

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                D[i][j] = A[i][j];
            }
        }

        // k = 거쳐가는 노드
        for (int k = 0; k < number; k++) {
            // i = 출발 노드
            for (int i = 0; i < number; i++) {
                // j = 도착 노드
                for (int j = 0; j < number; j++) {
                    if (D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }
}
