import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P24480_깊이우선탐색2 {
	static int N; // 정점의 수
	static int M; // 간선의 수
	static int R; // 시작 정점
	static ArrayList<ArrayList<Integer>> A; // 인접 리스트
	static int[] visited; // 방문 체크 배열
	static int count; // 방문 순서 체크
	static int INF = 100000000;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		A = new ArrayList<>();
		visited = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			A.add(new ArrayList<Integer>());
		}
		
		Arrays.fill(visited, INF);
		for (int i = 0; i < M; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			A.get(start).add(end);
			A.get(end).add(start);
		}
		
		// 내림차순 정렬
		for (int i = 0; i < A.size(); i++) {
			Collections.sort(A.get(i), (o1, o2) -> {
				return o2 - o1;
			});	
		}
		
		count = 1;
		DFS(R);
		
		for (int i = 1; i <= N; i++) {
			int ans = visited[i] == INF ? 0 : visited[i];
			System.out.println(ans);
		}		       
	}
	
	public static void DFS(int start) {
		visited[start] = count;
		for (int i = 0; i < A.get(start).size(); i++) {
			int newNode = A.get(start).get(i);
			if (visited[newNode] == INF) {
				count++;
				DFS(newNode);				
			}
		}
	}

}
