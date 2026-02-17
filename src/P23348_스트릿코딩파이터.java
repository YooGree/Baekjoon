import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P23348_스트릿코딩파이터 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int skillGradeA = Integer.parseInt(st.nextToken());
        int skillGradeB = Integer.parseInt(st.nextToken());
        int skillGradeC = Integer.parseInt(st.nextToken());
        int clubNum = Integer.parseInt(br.readLine());

        int maxGrade = 0;
        for (int i = 0; i < clubNum; i++) {
            int clubGrade = 0;
            for (int j = 0; j < 3; j++) {
                st = new StringTokenizer(br.readLine(), " ");
                clubGrade = clubGrade
                        + Integer.parseInt(st.nextToken()) * skillGradeA
                        + Integer.parseInt(st.nextToken()) * skillGradeB
                        + Integer.parseInt(st.nextToken()) * skillGradeC;
            }
            maxGrade = Math.max(clubGrade, maxGrade);
        }

        System.out.print(maxGrade);

    }
}
