import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class P1717_집합의표현 {
    static int[] A;
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 배열 초기화
        A = new int[N + 1];
        for (int i = 1; i < A.length; i++) {
            A[i] = i;
        }

        // 유니온파인드 연산 수행
        for (int i = 0; i < M; i++) {
            int input = sc.nextInt();
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (input == 0) {
                // Union
                union(num1, num2);
            } else {
                // Find
                if (find(num1) == find(num2)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    private static void union (int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) {
                A[b] = a;
            } else {
                A[a] = b;
            }
        }
    }

    private static int find (int a) {
        if (A[a] == a) return a; // 현재 인덱스값과 벨류값이 같다면 해당 벨류값은 루트노드의 값이다.
        else return A[a] = find(A[a]);
    }
}
