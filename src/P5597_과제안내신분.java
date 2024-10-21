import java.util.Arrays;
import java.util.Scanner;

public class P5597_과제안내신분 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] student = new int[31];
        for (int i = 0; i < student.length; i++) {
            student[i] = i;
        }

        for (int i = 1; i < 29; i++) {
            int studentNum = sc.nextInt();
            student[studentNum] = 0; // 숙제를 낸 학생은 0으로 지우기
        }

        Arrays.sort(student);

        for (int i = 0; i < student.length; i++) {
            if (student[i] != 0) {
                System.out.println(student[i]);
            }
        }

    }
}
