import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1956_운동 {
	static int V; // 도시의 수
	static int E; // 도시를 잇는 도로의 수
	static int[][] A; // 모든 정점의 최단거리를 저장할 2차원 배열
	static int INF = 100000000;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		A = new int[V + 1][V + 1];
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					continue;
				}
				A[i][j] = INF;
			}
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			A[start][end] = cost;
		}
		
		floydWarshall();
		
		// 플로이드 와샬 알고리즘으로 모든 정점의 최단거리를 구한 이후 사이클이 존재하는지 확인
		int ans = INF;
		
		for (int i = 1; i <= V; i++) {
			for (int j = 1; j <= V; j++) {
				if (i == j) {
					continue;
				}
				// 서로에게 갈수있는 거리가 있다면
				if (A[i][j] != INF && A[j][i] != INF) {
					ans = Math.min(ans, A[i][j] + A[j][i]);
				}
			}
		}			
		
		ans = ans == INF ? -1 : ans; 
		
		System.out.println(ans);		
	}
	
	static void floydWarshall() {
		for (int k = 1; k <= V; k++) {
			for (int i = 1; i <= V; i++) {
				for (int j = 1; j <= V; j++) {
					if (A[i][j] > A[i][k] + A[k][j]) {
						A[i][j] = A[i][k] + A[k][j];
					}
				}
			}
		}
	}

}
