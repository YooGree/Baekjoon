import java.util.Scanner;
import java.util.Stack;

public class P1874_스택수열 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nArr = new int[N];

        for (int i = 0; i < N; i++) {
            nArr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1;
        boolean result = true;
        StringBuffer bf = new StringBuffer();

        for (int i = 0; i < nArr.length; i++) {
            if (num <= nArr[i]) {
                while (num <= nArr[i]) {
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            } else {
                int temp = stack.pop();
                if (temp > nArr[i]) {
                    System.out.println("NO");
                    result = false;
                    break;
                } else {
                    bf.append("-\n");
                }

            }
        }

        if (result) System.out.println(bf.toString());
    }
}
