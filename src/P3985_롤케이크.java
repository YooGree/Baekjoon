import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3985_롤케이크 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        // 롤 케이크의 길이
        int L = Integer.parseInt(br.readLine());
        boolean[] cake = new boolean[L];
        // 방청객의 수
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] K = new int[N];
        // 방청객들이 적은 수 P, K (p번~k번 조각을 원함)
        int pre_Max_Value = Integer.MIN_VALUE;
        int pre_Max_Idx = 0;
        int real_Max_Value = Integer.MIN_VALUE;
        int real_Max_Idx = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            P[i] = Integer.parseInt(st.nextToken())-1;
            K[i] = Integer.parseInt(st.nextToken())-1;
            // 가장 많은 조각을 받을 것으로 기대하고 있던 방청객의 번호
            if(pre_Max_Value < (K[i] - P[i] + 1)) {
                pre_Max_Value = K[i] - P[i] + 1;
                pre_Max_Idx = i;
            }
            int count = 0;
            for (int j = P[i]; j <= K[i]; j++) {
                // 케이크가 있는경우에만 나눠준다.
                if(cake[j] == false) {
                    cake[j] = true;
                    count++;
                }
            }
            // 실제로 가장 많이 받은 방청객의 번호
            if(count > real_Max_Value) {
                real_Max_Value = count;
                real_Max_Idx = i;
            }
        }
        // 배열의 index값으로 넣었으니 실제로는 +1을 해줘야한다.
        System.out.println(pre_Max_Idx+1);
        System.out.println(real_Max_Idx+1);
        br.close();
    }
}
