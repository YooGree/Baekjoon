import java.util.ArrayList;
import java.util.Scanner;

public class P2605_줄세우기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();
		int N = sc.nextInt();
		
		for(int i=0;i<N;i++) {
			int num = sc.nextInt();
			
			if(num == 0) list.add(i+1);
			else list.add(list.size()-num, i+1);
		}
		
		for(int i :list)
			System.out.print(i+" ");
	}
}
