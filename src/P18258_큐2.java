import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18258_큐2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int N = Integer.parseInt(br.readLine());
       // Queue<Integer> queue = new PriorityQueue<>();
        Deque<Integer> dqueue = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            switch (command) {
                case "push":
                    dqueue.add(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    if (dqueue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dqueue.poll() + "\n");
                    }
                    break;
                case "size":
                    sb.append(dqueue.size() + "\n");
                    break;
                case "empty":
                    if (dqueue.isEmpty()) {
                        sb.append(1 + "\n");
                    } else {
                        sb.append(0 + "\n");
                    }
                    break;
                case "front":
                    if (dqueue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dqueue.getFirst() + "\n");
                    }
                    break;
                case "back":
                    if (dqueue.isEmpty()) {
                        sb.append(-1 + "\n");
                    } else {
                        sb.append(dqueue.getLast() + "\n");
                    }
                    break;
            }
        }

        System.out.println(sb);

    }
}
