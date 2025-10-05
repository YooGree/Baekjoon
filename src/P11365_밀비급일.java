import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P11365_밀비급일 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.equals("END")) break;

            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                stack.push(ch);
            }

            StringBuilder sb = new StringBuilder();
            while (!stack.isEmpty()) {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
