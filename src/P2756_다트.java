import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P2756_다트 {
    static class Position {
        double x, y;

        Position(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int getScore(List<Position> player) {
        int sum = 0;

        // 3번 진행
        for (int i = 0; i < 3; i++) {
            double len = Math.sqrt(
                    player.get(i).x * player.get(i).x +
                            player.get(i).y * player.get(i).y
            );

            if (len <= 3) {
                sum += 100;
            } else if (len <= 6) {
                sum += 80;
            } else if (len <= 9) {
                sum += 60;
            } else if (len <= 12) {
                sum += 40;
            } else if (len <= 15) {
                sum += 20;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();

        for (int i = 0; i < testCase; i++) {
            List<Position> v = new ArrayList<>();
            List<Position> player1 = new ArrayList<>();
            List<Position> player2 = new ArrayList<>();

            // 6개 입력
            for (int j = 0; j < 6; j++) {
                double x = sc.nextDouble();
                double y = sc.nextDouble();
                v.add(new Position(x, y));
            }

            // 플레이어1 (0~2)
            for (int j = 0; j < 3; j++) {
                player1.add(v.get(j));
            }

            // 플레이어2 (3~5)
            for (int j = 3; j < 6; j++) {
                player2.add(v.get(j));
            }

            int player1Score = getScore(player1);
            int player2Score = getScore(player2);

            System.out.print("SCORE: " + player1Score + " to " + player2Score + ", ");

            if (player1Score == player2Score) {
                System.out.println("TIE.");
            } else if (player1Score > player2Score) {
                System.out.println("PLAYER 1 WINS.");
            } else {
                System.out.println("PLAYER 2 WINS.");
            }
        }

        sc.close();
    }
}
