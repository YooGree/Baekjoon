import java.time.LocalDate;
import java.time.DayOfWeek;
import java.util.Scanner;

public class P2948_2009년 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int D = scanner.nextInt(); // 일
        int M = scanner.nextInt(); // 월

        // 2009년 M월 D일 날짜 생성
        LocalDate date = LocalDate.of(2009, M, D);
        DayOfWeek dayOfWeek = date.getDayOfWeek();

        // 첫 글자만 대문자로 변환해서 출력
        String dayName = dayOfWeek.toString().substring(0, 1).toUpperCase()
                + dayOfWeek.toString().substring(1).toLowerCase();

        System.out.println(dayName);
    }
}
