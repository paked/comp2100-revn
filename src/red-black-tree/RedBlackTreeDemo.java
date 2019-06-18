public class RedBlackTreeDemo {
    public static void main(String[] args) {
        RedBlackTree rbt = new RedBlackTree();

        /*
        rbt.insert(1);
        rbt.insert(2);*/

        for(int i=0; i<20; ++i) {
            rbt.insert(i);
        }

        System.out.println(rbt.toString());
    }
}
