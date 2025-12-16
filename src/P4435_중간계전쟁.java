import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4435_중간계전쟁 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int i = 0; i < T; i++) {
            int score1 = 0;
            int score2 = 0;

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 6; j++) {
                int cnt = Integer.parseInt(st.nextToken());
                switch (j) {
                    case 0:
                        score1 += cnt * 1;
                        break;
                    case 1:
                        score1 += cnt * 2;
                        break;
                    case 2:
                         score1 += cnt * 3;
                         break;
                    case 3:
                        score1 += cnt * 3;
                        break;
                    case 4:
                        score1 += cnt * 4;
                        break;
                    case 5:
                        score1 += cnt * 10;
                        break;
                }
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 7; j++) {
                int cnt = Integer.parseInt(st.nextToken());
                switch (j) {
                    case 0:
                        score2 += cnt * 1;
                        break;
                    case 1:
                        score2 += cnt * 2;
                        break;
                    case 2:
                        score2 += cnt * 2;
                        break;
                    case 3:
                        score2 += cnt * 2;
                        break;
                    case 4:
                        score2 += cnt * 3;
                        break;
                    case 5:
                        score2 += cnt * 5;
                        break;
                    case 6:
                        score2 += cnt * 10;
                        break;

                }
            }

            if (score1 > score2) {
                System.out.println("Battle " + (i + 1) + ": Good triumphs over Evil");
            } else if (score1 < score2) {
                System.out.println("Battle " + (i + 1) + ": Evil eradicates all trace of Good");
            } else {
                System.out.println("Battle " + (i + 1) + ": No victor on this battle field");
            }

        }
    }
}
