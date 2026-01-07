import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P5218_알파벳거리 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 첫 번째 줄에서 테스트 케이스의 수를 읽어 정수로 변환
        int testCases = Integer.parseInt(sc.nextLine());

        // 테스트 케이스의 수만큼 반복하여 각 테스트 케이스를 처리
        for (int i = 0; i < testCases; i++) {
            // 사용자로부터 두 단어를 입력받아 공백으로 구분하여 배열에 저장
            String[] words = sc.nextLine().split(" ");
            // 두 단어를 각각 문자 배열로 변환
            char[] word1 = words[0].toCharArray();
            char[] word2 = words[1].toCharArray();

            // calculateDistances 함수를 호출하여 두 단어 사이의 알파벳 거리를 계산
            int[] distances = calculateDistances(word1, word2);

            // 계산된 거리를 출력. "Distances: "로 시작하여 각 거리를 공백으로 구분하여 출력
            System.out.print("Distances: ");
            for (int distance : distances) {
                System.out.print(distance + " ");
            }
            // 각 테스트 케이스의 출력을 구분하기 위해 줄바꿈 추가
            System.out.println();
        }
    }

    // 두 단어 사이의 알파벳 거리를 계산하는 함수
    private static int[] calculateDistances(char[] word1, char[] word2) {
        // 계산된 거리를 저장할 정수 배열을 생성. 배열의 크기는 입력된 단어의 길이와 같음
        int[] distances = new int[word1.length];

        // 단어의 각 글자에 대해 반복하여 거리를 계산
        for (int i = 0; i < word1.length; i++) {
            // 두 글자 사이의 거리를 계산
            int distance = word2[i] - word1[i];
            // 거리가 음수인 경우, 26을 더하여 거리를 양수로 조정
            if (distance < 0) {
                distance += 26;
            }
            // 계산된 거리를 배열에 저장
            distances[i] = distance;
        }

        // 계산된 거리 배열을 반환
        return distances;
    }
}
