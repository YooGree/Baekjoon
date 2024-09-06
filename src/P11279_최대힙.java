import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P11279_최대힙 {
    static int N; // 연산의 갯수
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        pq = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 우선순위 큐

        for (int i = 0; i < N; i++) {
            int value = sc.nextInt();
            if (value == 0) {
                if (pq.peek() == null) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            }
            pq.offer(value);
        }
    }
}
