import java.util.PriorityQueue;
import java.util.Scanner;

public class P1927_최소힙 {
    static int N;
    static PriorityQueue<Integer> pq;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            if (num == 0) {
                if (pq.peek() == null) {
                    System.out.println(0);
                } else {
                    System.out.println(pq.poll());
                }
            } else {
                pq.offer(num);
            }
        }
    }
}
