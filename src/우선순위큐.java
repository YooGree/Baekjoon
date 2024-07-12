import java.util.Collections;
import java.util.PriorityQueue;

public class 우선순위큐 {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        StringBuilder sb = new StringBuilder();

        // 1. 낮은숫자가 우선순위인 int형 우선순위 큐 선언
        PriorityQueue<Integer> pQueueLowest = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pQueueLowest.offer(arr[i]);
        }

        while (!pQueueLowest.isEmpty()) {
            sb.append(pQueueLowest.poll() + " ");
        }

        System.out.println("1. 낮은숫자 우선순위 큐");
        System.out.println(sb.toString());
        System.out.println();

        // 2. 높은숫자가 우선순위인 int형 우선순위 큐 선언
        //sb.delete();
        sb.setLength(0);
        PriorityQueue<Integer> pQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            pQueueHighest.offer(arr[i]);
        }

        while (!pQueueHighest.isEmpty()) {
            sb.append(pQueueHighest.poll() + " ");
        }

        System.out.println("2. 높은숫자 우선순위 큐");
        System.out.println(sb.toString());
        System.out.println();
        
        // 3. 사용자 정의 객체에 따른 사용자 정의 우선순위 큐 선언
        sb.setLength(0);
        PriorityQueue<Student> pQueueCustom = new PriorityQueue<>();
        pQueueCustom.offer(new Student("철수", 20, 95));
        pQueueCustom.offer(new Student("영희", 25, 80));
        pQueueCustom.offer(new Student("민수", 40, 97));
        pQueueCustom.offer(new Student("하영", 32, 70));
        pQueueCustom.offer(new Student("현수", 18, 60));
        pQueueCustom.offer(new Student("재신", 50, 70));

        while (!pQueueCustom.isEmpty()) {
            sb.append(pQueueCustom.poll() + " ");
        }

        System.out.println("3. 사용자 정의 우선순위 큐");
        System.out.println(sb.toString());
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;
    public Student (String name, int age, int score) {
        super();
        this.name = name;
        this.age = age;
        this.score = score;
    }

    // 점수가 더 높은 학생이 맨앞으로 오고, 점수가 같다면 나이가 많은 학생이 앞으로 온다.
    @Override
    public int compareTo(Student o) {
        /*
        1. 현재 객체가 비교 대상 객체보다 크다면 양수를 반환 (this.age > o.age)
        2. 현재 객체와 비교 대상 객체가 같다면 0을 반환 (this.age == o.age)
        3. 현재 객체가 비교 대상 객체보다 작다면 음수를 반환 (this.age < o.age)
         */
        
        if (this.score == o.score) {
            // 점수가 같다면 나이로 내림차순
            return o.age - this.age;
        } else {
            // 점수가 다르다면 점수로 내림차순
            return o.score - this.score;
        }
    }

    @Override
    public String toString() {
        return "[name: " + this.name + " age: " + this.age + " score: " + this.score + "]";
    }
}
