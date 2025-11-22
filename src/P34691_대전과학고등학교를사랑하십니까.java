import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P34691_대전과학고등학교를사랑하십니까 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String s = br.readLine();
            if (s.equals("end")) break;
            switch (s) {
                case "animal":
                    System.out.println("Panthera tigris");
                    break;
                case "flower":
                    System.out.println("Forsythia koreana");
                    break;
                case "tree":
                    System.out.println("Pinus densiflora");
                    break;
            }
        }
    }
}
