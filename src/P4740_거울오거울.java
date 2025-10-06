import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class P4740_거울오거울 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Character> stack = new ArrayDeque<>();

        while (true) {
            String str = br.readLine();
            if (str.equals("***")) {
                break;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                stack.push(c);
            }

            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());
        }
    }
}

