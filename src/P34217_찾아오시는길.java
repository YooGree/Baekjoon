import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P34217_찾아오시는길 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A =  Integer.parseInt(st.nextToken());
        int B =  Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int hanYang = A + C;
        int yongDap = B + D;

        if (hanYang < yongDap) {
            System.out.println("Hanyang Univ.");
        } else if (hanYang > yongDap) {
            System.out.println("Yongdap");
        } else {
            System.out.println("Either");
        }

    }
}
