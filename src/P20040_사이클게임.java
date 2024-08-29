import java.util.Arrays;
import java.util.Scanner;

public class P20040_사이클게임 {
    static int n; // 점의 개수
    static int m; // 두 점 사이를 이은 횟수
    static int[] parent;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (find(x) == find(y)) {
                System.out.println(i + 1);
                return;
            } else {
                union(x, y);
            }
        }

        System.out.println(0);
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int pX = find(x);
        int pY = find(y);
        if (pX != pY) {
            if (pX < pY) {
                parent[pY] = pX;
            } else {
                parent[pX] = pY;
            }
        }

    }
}
