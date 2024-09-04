import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P5639_이진검색트리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 전위순회(루트, 왼쪽, 오른쪽)의 입력을 그냥 순서대로 넣으면 이진검색트리가 구현된다.
        Node rootNode = new Node(Integer.parseInt(br.readLine()));
        String temp;
        while ((temp = br.readLine()) != null && !temp.equals("")) {
            rootNode.addNode(new Node(Integer.parseInt(temp)));
        }

        postOrder(rootNode);
    }

    public static void postOrder(Node N) {
        if (N == null) {
            return;
        }

        postOrder(N.left);
        postOrder(N.right);
        System.out.println(N.num);
    }

    public static class Node {
        Node left;
        Node right;
        int num;

        public Node(int num) {
            left = null;
            right = null;
            this.num = num;
        }

        public void addNode(Node newNode) {
            if (this.num > newNode.num) {
                if (this.left == null) {
                    this.left = newNode;
                } else {
                    this.left.addNode(newNode);
                }
            } else {
                if (this.right == null) {
                    this.right = newNode;
                } else {
                    this.right.addNode(newNode);
                }
            }
        }
    }
}
