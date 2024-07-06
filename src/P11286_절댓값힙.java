import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class P11286_절댓값힙 {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bfr.readLine());
        StringBuffer sbf = new StringBuffer();

        PriorityQueue<Integer> pQueue = new PriorityQueue<>((o1, o2) -> {
            int firstAbs = Math.abs(o1);
            int secondAbs = Math.abs(o2);
            if (firstAbs == secondAbs) {
                return o1 - o2;
            }
            return firstAbs - secondAbs;
        });

        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(bfr.readLine());
            if (input == 0) {
                if (pQueue.isEmpty()) {
                    sbf.append("0\n");
                } else {
                    sbf.append(pQueue.poll() + "\n");
                }
            } else {
                pQueue.add(input);
            }
        }

        System.out.println(sbf.toString());

    }
}
