import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1991_트리순회 {
    static int N; // 노드의 갯수
    static Node[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        tree = new Node[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if (tree[parent - 'A'] == null) { // 부모 노드가 아직 생성되지 않은 경우. 'A'는 문자 'A'의 ASCII 값
                tree[parent - 'A'] = new Node(parent); // 부모 노드를 생성
            }
            if (left != '.') { // 왼쪽 자식이 존재할 경우
                tree[left - 'A'] = new Node(left); // 왼쪽 자식 노드를 생성
                tree[parent - 'A'].left = tree[left - 'A']; // 부모 노드와 연결
            }
            if (right != '.') { // 오른쪽 자식이 존재할 경우
                tree[right - 'A'] = new Node(right); // 오른쪽 자식 노드를 생성
                tree[parent - 'A'].right = tree[right - 'A']; // 부모 노드와 연결
            }
        }

        preorder(tree[0]);
        System.out.println();

        inorder(tree[0]);
        System.out.println();

        postorder(tree[0]);
        System.out.println();
    }

    // 전위 순회 (루트 - 왼쪽자식 - 오른쪽자식)
    public static void preorder(Node node) {
        if (node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);
    }

    // 중위 순회 (왼쪽자식 - 루트 - 오른쪽자식)
    public static void inorder(Node node) {
        if (node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);
    }

    // 후위 순회 (왼쪽자식 - 오른쪽자식 - 루트)
    public static void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.value);
    }

    public static class Node {
        char value;
        Node left;
        Node right;
        public Node (char value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
}

