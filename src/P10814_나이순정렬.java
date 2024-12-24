import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P10814_나이순정렬 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Person[] person = new Person[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            person[i] = new Person(i, age, name);
        }

        Arrays.sort(person, (p1, p2) -> {
            if (p1.age == p2.age) {
                return Integer.compare(p1.seq, p2.seq);
            }
            return Integer.compare(p1.age, p2.age);
        });

        StringBuilder sb = new StringBuilder();
        for (Person p : person) {
            sb.append(p.age + " " + p.name).append("\n");
        }
        System.out.println(sb);

     }

     static class Person {
        int seq;
        int age;
        String name;
        public Person (int seq, int age, String name) {
            this.seq = seq;
            this.age = age;
            this.name = name;
        }
    }
}
