import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14625_냉동식품 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. hour, minutes 변수를 새로 만든다.
        // 2. hour = startHour로 한다.
        // 3. minutes++하면서 60이 되면 hour을 +1한다.
        // 4. hour과 minutes이 end와 같아질 때 종료한다.
        // 4-1. hour이 24가 되면 0으로 변경한다.

        int startHour = Integer.parseInt(st.nextToken());
        int startMinute = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int endHour = Integer.parseInt(st.nextToken());
        int endMinute = Integer.parseInt(st.nextToken());

        int numN = Integer.parseInt(br.readLine());

        int hour = startHour;
        int minutes = startMinute;
        int count = 0;

        while (true) {
            String str = String.valueOf(numN);

            String changeHour = String.valueOf(hour);
            String changeMinutes = String.valueOf(minutes);

            if (changeHour.length() == 1) {
                changeHour = "0" + changeHour;
            }

            if (changeMinutes.length() == 1) {
                changeMinutes = "0" + changeMinutes;
            }

            if (changeHour.contains(str) || changeMinutes.contains(str)) {
                count++;
            }

            if (hour == endHour && minutes == endMinute) {
                break;
            }

            minutes++;

            if (minutes == 60) {
                hour++;
                minutes = 0;
            }

            if (hour == 24) {
                hour = 0;
            }
        }

        sb.append(count);
        System.out.println(sb.toString());
    }
}
