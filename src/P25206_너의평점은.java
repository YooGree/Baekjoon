import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P25206_너의평점은 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List<gradeReport> gradeList = new ArrayList<>();
        double subjectTotalSum = 0;
        double subjectSum = 0;

        for (int i = 0; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            gradeList.add(new gradeReport(st.nextToken(), Double.parseDouble(st.nextToken()), st.nextToken()));
        }

        for (gradeReport report : gradeList) {
            if (!report.grade.equals("P")) {
                // 등급이 "P"인 과목은 제외한다.
                subjectTotalSum +=  report.score;
                switch (report.grade) {
                    case "A+":
                        subjectSum += report.score * 4.5;
                        break;
                    case "A0":
                        subjectSum += report.score * 4.0;
                        break;
                    case "B+":
                        subjectSum += report.score * 3.5;
                        break;
                    case "B0":
                        subjectSum += report.score * 3.0;
                        break;
                    case "C+":
                        subjectSum += report.score * 2.5;
                        break;
                    case "C0":
                        subjectSum += report.score * 2.0;
                        break;
                    case "D+":
                        subjectSum += report.score * 1.5;
                        break;
                    case "D0":
                        subjectSum += report.score;
                        break;
                    case "F":
                        subjectSum += report.score * 0;
                        break;
                }
            }
        }

        double resultScore = subjectSum / subjectTotalSum;
        System.out.println(resultScore);
    }

    public static class gradeReport {
        public String subject; // 과목명
        public double score; // 학점
        public String grade; // 등급

        public gradeReport(String subject, double score, String grade) {
            this.subject = subject;
            this.score = score;
            this.grade = grade;
        }
    }
}
