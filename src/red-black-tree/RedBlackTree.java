public class RedBlackTree {
    public enum Color {
        BLACK,
        RED
    }

    public class Node {
        public Color color;
        public Integer value;

        public Node left;
        public Node right;
        public Node parent;

        public Node(Node parent) {
            this.color = Color.BLACK;
            this.value = null;
            this.parent = parent;
        }

        public Node(Node parent, Integer value) {
            this.color = Color.RED;
            this.value = value;

            this.left = new Node(this);
            this.right = new Node(this);
            this.parent = parent;
        }

        // Rotate the node so it becomes the child of its right branch
        /*
            e.g.
                  [x]                    b
                 /   \                 /   \     
               a       b     == >   [x]     f    
              / \     / \           /  \      
             c  d    e   f         a    e
                                  / \
                                 c   d
        */
        public void rotateLeft() {
            // Make parent (if it exists) and right branch point to each other
            if (parent != null) {
                // Determine whether this node is the left or right child of its parent
                if (parent.left.value == value) {
                    parent.left = right;
                } else {
                    parent.right = right;
                }
            }

            right.parent = parent;

            parent = right;
            // Take right node's left branch
            right = parent.left;
            right.parent = this;
            // Take the place of the right node's left branch
            parent.left = this;
        }

        // Rotate the node so it becomes the child of its left branch
        /*
            e.g.
                  [x]                    a
                 /   \                 /   \     
               a       b     == >     c     [x]   
              / \     / \                   /  \      
             c  d    e   f                 d    b
                                               / \
                                              e   f
        */
        public void rotateRight() {
            // Make parent (if it exists) and left branch point to each other
            if (parent != null) {
                // Determine whether this node is the right or left child of its parent
                if (parent.right.value == value) {
                    parent.right = left;
                } else {
                    parent.left = left;
                }
            }

            left.parent = parent;

            parent = left;
            // Take left node's right branch
            left = parent.right;
            left.parent = this;
            // Take the place of the left node's right branch
            parent.right = this;
        }
    }

    private Node root;

    public RedBlackTree() {
        this.root = new Node(null);
    }

    // The Rules of a Red Black Tree
    // 1. Every node is either red or black
    // 2. Root is always black
    // 3. New insertions are always red
    // 4. Every path from root to leaf has the same number of black nodes
    // 5. No path can have two consecutive red nodes
    // 6. Null nodes are black
    //
    // If one of these rules are broken, we either:
    // 1. Rotate (if black aunt)
    // 2. Colour flip (if red aunt)
    public void insert(Integer n) {
        Node node = insert(root, n);

        fix(node);
    }

    public Node insert(Node head, Integer n) {
        if (head.value == null) {
            head.color = Color.RED;
            head.value = n;

            head.left = new Node(head);
            head.right = new Node(head);

            return head;
        }

        if (n < head.value) {
            return insert(head.left, n);
        }

        if (n > head.value) {
            return insert(head.right, n);
        }

        return null;
    }

    private void fix(Node node) {
        // check:
        // 1. no path has two consecutive red nodes
        // 2.

        while (node.parent.color == Color.RED) {
            Node uncle = null;
            if (node.parent == node.parent.parent.left) {
                uncle = node.parent.parent.right;

                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                    continue;
                } 
                if (node == node.parent.right) {
                    //Double rotation needed
                    node = node.parent;
                    node.rotateLeft();
                } 
                node.parent.color = Color.BLACK;
                node.parent.parent.color = Color.RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation 
                node.parent.parent.rotateRight();
            } else {
                uncle = node.parent.parent.left;
                if (uncle != null && uncle.color == Color.RED) {
                    node.parent.color = Color.BLACK;
                    uncle.color = Color.BLACK;
                    node.parent.parent.color = Color.RED;
                    node = node.parent.parent;
                    continue;
                }

                if (node == node.parent.left) {
                    //Double rotation needed
                    node = node.parent;
                    node.rotateRight();
                }
                node.parent.color = Color.BLACK;
                node.parent.parent.color = Color.RED;
                //if the "else if" code hasn't executed, this
                //is a case where we only need a single rotation
                node.parent.parent.rotateLeft();
            }
        }

        root.color = Color.BLACK;
    }

	public String toString() {
        return toString(root);
    }

    public String toString(Node head) {
        if (head.value != null) {
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
