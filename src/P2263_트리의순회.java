import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class P2263_트리의순회 {
    static int n;
    static int[] in, post, pre;
    static int idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        pre = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(st.nextToken());
        }

        getPreOrder(0, n - 1, 0, n - 1);

        for (int i = 0; i < pre.length; i++) {
            System.out.print(pre[i] + " ");
        }
    }

    public static void getPreOrder(int is, int ie, int ps, int pe) {
        if (is <= ie && ps <= pe) {
            pre[idx++] = post[pe]; // 포스트 오더의 가장 오른쪽은 루트노드
            int root = 0;
            for (int i = is; i <= ie; i++) {
                if (in[i] == post[pe]) {
                    // 인 오더에서 루트 노드의 위치를 찾는다.
                    root = i;
                    break;
                }
            }
            getPreOrder(is, root - 1, ps, root + ps - is - 1); // 왼쪽 자식트리를 가지고 다시 프리오더를 구한다.
            getPreOrder(root + 1, ie, root + ps - is, pe - 1); // 오른쪽 자식트리를 가지고 다시 프리오더를 구한다.
        }
    }
}
