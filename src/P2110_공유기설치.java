import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110_공유기설치 {
    private static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house); // 이분탐색을 하기 위해서 정렬

        int low = 1; // 최소거리가 가질 수 있는 최솟값
        int high = house[N - 1] - house[0] + 1; // 최소거리가 가질 수 있는 최댓값
        while (low < high) {
            int mid = (low + high) / 2;

            if (getInstallCount(mid) < C) {
                // mid 거리에 대해 설치 가능한 공유기 개수가 C개에 미치지 못하면 거리를 좁힌다.
                high = mid;
            } else {
                // 설치 가능한 공유개의 개수가 C개보다 크거나 같으면 거리를 벌리면서 최소거리가 가질 수 있는 최대거리를 찾는다.
                low = mid + 1;
            }
        }

        System.out.println(low - 1);
    }

    // 현재 거리에 대해 설치 가능한 공유기의 갯수를 찾는 메소드
    public static int getInstallCount(int distince) {
        // 첫번째 집은 무조건 설치한다고 가정한다.
        int count = 1;
        int lastLocate = house[0];

        for (int i = 1; i < house.length; i++) {
            int locate = house[i];
            if (locate - lastLocate >= distince) {
                // 현재 탐색하는 집의 위치와 직전에 설치했던 집의 우ㅟ치간 거리가 최소거리보다 크거나 같으면
                // 공유기 설치개수를 늘려주고 마지막 설치위치를 갱신한다.
                count++;
                lastLocate = locate;
            }
        }
        return count;
    }
}
