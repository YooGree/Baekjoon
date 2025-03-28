import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class P12789_도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 번호표 받는 사람

        int index = 1; // 현재 간식 줄라는 번호표
        String result = "Nice";	// 현재 줄이 제대로 서있을 수 있으므로 기본 값 Nice
        String[] sArr = br.readLine().split(" ");
        Stack<Integer> stack = new Stack<>();

        // 현재 줄 + 대기 줄 사람 처리
        for (int i = 0; i < N; i++){
            int currentNum = Integer.parseInt(sArr[i]);
            if (index != currentNum){
                if (!stack.isEmpty() && index == stack.peek()){
                    index++;
                    i--;
                    stack.pop();
                } else {
                    stack.push(currentNum);
                }
            } else {
                index++;
            }
        }

        // 대기줄에 있는 사람 처리
        while(!stack.isEmpty()){
            int pop = stack.pop();
            if(pop == index){
                index++;
            } else {
                result = "Sad";
                break;
            }
        }
        System.out.println(result);

    }
}
