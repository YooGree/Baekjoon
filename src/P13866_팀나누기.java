import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P13866_팀나누기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] arr = new int[4];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            arr[i] =  Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        System.out.println(Math.abs((arr[0] + arr[3]) - (arr[1] + arr[2])));
    }
}
