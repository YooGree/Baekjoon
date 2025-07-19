import java.util.Scanner;

public class P34052_체육은수학과목입니다2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int total = 0;

        // 4바퀴의 시간 입력
        for (int i = 0; i < 4; i++) {
            int time = sc.nextInt();
            total += time;
        }

        // 마지막 바퀴는 300초로 고정
        total += 300;

        // 조건 판단
        if (total <= 1800) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
