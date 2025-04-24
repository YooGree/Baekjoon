import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    static class Person {
        int id;
        int arrival;
        int time;

        Person(int id, int arrival, int time) {
            this.id = id;
            this.arrival = arrival;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        // 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Person> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] tokens = br.readLine().split(" ");
            int arrival = Integer.parseInt(tokens[0]);
            int time = Integer.parseInt(tokens[1]);
            people.add(new Person(i + 1, arrival, time));
        }

        // 도착 시간 기준 정렬
        people.sort(Comparator.comparingInt(p -> p.arrival));

        // 우선순위 큐: id가 작은 사람 우선
        PriorityQueue<Person> pq = new PriorityQueue<>(Comparator.comparingInt(p -> p.id));

        long currentTime = 0;
        int index = 0;
        long maxWait = 0;

        while (index < N || !pq.isEmpty()) {
            // 먼저 도착해서 기다리는 사람들을 대기 큐에 추가
            while (index < N && people.get(index).arrival <= currentTime) {
                pq.add(people.get(index));
                index++;
            }

            if (!pq.isEmpty()) {
                Person person = pq.poll();
                long waitTime = currentTime - person.arrival;
                maxWait = Math.max(maxWait, waitTime);
                currentTime += person.time;
            } else {
                // 아무도 도착하지 않았다면 다음 사람 시간까지 이동
                currentTime = people.get(index).arrival;
            }
        }

        System.out.println(maxWait);
    }
}
