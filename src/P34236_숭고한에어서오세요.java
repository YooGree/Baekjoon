import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class P34236_숭고한에어서오세요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        int num = 0;
        for (int i = 0; i < N; i++) {
            int year = Integer.parseInt(st.nextToken());
            if (i == 0) num = year;
            else if (i == 1) num = year - num;
            stack.push(year);
        }

        System.out.println(stack.peek() + num);
    }
}
