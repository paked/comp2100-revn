package generics;

/**
 * BinaryTreeDemo - some code to demo the use of the binary sorted tree.
 * @author Eric McCreath - GPLv2
 */


public class BinaryTreeDemo {

	
	public static void main(String[] args) {
//		BinaryTree<Integer> bt = new NonEmptyBinaryTree<Integer>(5, new NonEmptyBinaryTree<Integer>(3), new NonEmptyBinaryTree<Integer>(13,new NonEmptyBinaryTree<Integer>(8), new NonEmptyBinaryTree<Integer>(14)));
//		System.out.println("size : " + bt.size());
//		
//		System.out.println(bt.treeshow());
//		System.out.println("insert 7 : ");
//		bt = bt.insert(7);
//		System.out.println(bt.treeshow());
//		System.out.println("insert 9 : ");
//		bt = bt.insert(9);
//		System.out.println(bt.treeshow());
//		System.out.println("remove 13 : ");
//		bt = bt.remove(13);
//		System.out.println(bt.treeshow());
		
		  BinaryTree<Integer> bt = new NonEmptyBinaryTree<Integer>(5);
		  System.out.println("size : " + bt.size());

		  System.out.println(bt.treeshow());
		  System.out.println("insert 7 : ");
		  bt = bt.insert(7);
		  System.out.println(bt.treeshow());
		  System.out.println("insert 9 : ");
		  bt = bt.insert(9);
		  System.out.println(bt.treeshow());
		  System.out.println("remove 13 : ");
		  bt = bt.remove(13);
		  System.out.println(bt.treeshow());

		  BinaryTree<String> stringBT = new NonEmptyBinaryTree<String>("string");
		  System.out.println("size : " + stringBT.size());

		  System.out.println(stringBT.treeshow());
		  System.out.println("insert \"hello\" : ");
		  stringBT = stringBT.insert("hello");
		  System.out.println(stringBT.treeshow());
		  System.out.println("insert \"hi\": : ");
		  stringBT = stringBT.insert("hi");
	}

}
