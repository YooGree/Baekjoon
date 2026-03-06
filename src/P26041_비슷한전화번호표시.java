import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P26041_비슷한전화번호표시 {
    public static void main(String[] args) throws Exception {
        // 조건 1. 주어진 번호와 아예 같으면 안된다.
        // 조건 2. 주어진 번호를 접두사로 가지고 있어야한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String question = br.readLine();
        String phone = br.readLine();

        int answer = 0;

        String [] str = question.split(" ");

        for (int i = 0; i < str.length; i++) {
            if (str[i].length() < phone.length()) {
                continue;
            } else {
                String isHavePhone = str[i].substring(0, phone.length());

                if (phone.equals(str[i])) {
                    continue;
                }

                if (isHavePhone.equals(phone)) {
                    answer++;
                }
            }
        }

        sb.append(answer);
        System.out.println(sb.toString());
    }
}
