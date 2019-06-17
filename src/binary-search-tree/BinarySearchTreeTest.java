public class BinarySearchTreeTest {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(7);
        bst.insert(3);
        bst.insert(1);
        bst.insert(5);
        bst.insert(4);
        bst.insert(11);
        bst.insert(10);
        bst.insert(15);

        // Correct output is: 7 3 1 5 4 11 10 15
        System.out.println(bst.toString());

        System.out.println(bst.find(7) != null); // true
        System.out.println(bst.find(9) != null); // false
        System.out.println(bst.find(12) != null); // false
        System.out.println(bst.find(6) != null); // false
    }
}
