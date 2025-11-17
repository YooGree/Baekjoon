import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class P28431_양말짝맞추기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            int num = Integer.parseInt(br.readLine());

            if (hm.containsKey(num)) {
                hm.put(num, hm.get(num) + 1);
            } else {
                hm.put(num, 1);
            }
        }

        hm.entrySet().forEach(entry -> {
            if (entry.getValue() % 2 != 0) {
                System.out.println(entry.getKey());
                return;
            }
        });
    }
}
