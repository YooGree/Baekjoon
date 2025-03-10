import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] temp = new int[N];
        List<Integer> list = new ArrayList<Integer>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            temp[i] = value;
        }

        for (int i = 0; i < N - K + 1; i++) {
            int sum = 0;
            for (int j = i; j < i + K; j++) {
                sum += temp[j];
            }
            list.add(sum);
        }

        list.stream().max(Integer::compareTo).ifPresent(System.out::println);
    }
}
