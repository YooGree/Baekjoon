import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2562_최댓값 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            list.add(sc.nextInt());
        }

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
                maxIndex = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(maxIndex);
    }
}
