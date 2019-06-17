public class BinarySearchTree {
    public class Node {
        public Integer value;

        public Node left;
        public Node right;

        public Node(Integer value) {
            this.value = value;
        }
    }

    private Node root;

    public void insert(Integer n) {
        if (root == null) {
            root = new Node(n);
        } else {
            insert(root, n);
        }
    }

    public void insert(Node head, Integer n) {
        if (n < head.value) {
            if (head.left == null) {
                head.left = new Node(n);

                return;
            }

            insert(head.left, n);
        } else if (n > head.value) {
            if (head.right == null) {
                head.right = new Node(n);

                return;
            }

            insert(head.right, n);
        }
    }

    public Node find(Integer target) {
        return find(root, target);
    }

    public Node find(Node root, Integer target) {
        if (root == null) {
            return null;
        }

        if (target < root.value) {
            return find(root.left, target);
        } else if (target > root.value) {
            return find(root.right, target);
        }

        return root;
    }

    public String toString() {
        return toString(root);
    }

    public String toString(Node head) {
        if (head != null) {
            String result = head.value.toString();

            String left = toString(head.left);
            String right = toString(head.right);

            if (left != null) {
                result += " " + left;
            }

            if (right != null) {
                result += " " + right;
            }

            return result;
        }

        return null;
    }
}
