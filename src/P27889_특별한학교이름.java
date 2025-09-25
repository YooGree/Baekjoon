import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P27889_특별한학교이름 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String ans = "";

        switch (str) {
            case "NLCS":
                ans = "North London Collegiate School";
                break;
                case "BHA":
                    ans = "Branksome Hall Asia";
                    break;
                    case "KIS":
                        ans = "Korea International School";
                        break;
                        case "SJA":
                            ans = "St. Johnsbury Academy";
                            break;
        }

        System.out.println(ans);
    }
}
