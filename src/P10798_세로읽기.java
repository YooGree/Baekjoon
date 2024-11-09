import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10798_세로읽기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        char[][] matrix = new char[5][15];
        int max = 0;

        for (int i = 0; i < matrix.length; i++) {
            String str = br.readLine();
            if (max < str.length())
                max = str.length();

            for (int j = 0; j < str.length(); j++) {
                matrix[i][j] = str.charAt(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if (matrix[j][i] == '\0') continue;
                sb.append(matrix[j][i]);
            }
        }

        System.out.println(sb);
    }
}
