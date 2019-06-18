package generics;

/**
 * 
 * EmptyBinaryTree - the is the empty tree.  Note it has no fields so all empty trees are the same.  
 * Note I have added a static factory method that just return the same object.  
 * This saves on creating many objects which are all just the same.
 * 
 * @author Eric McCreath - GPLv2
 */

public class EmptyBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {

//	static private EmptyBinaryTree<T> emptytree = new EmptyBinaryTree<T>();
//	
//	public static <T2 extends Comparable<T>> EmptyBinaryTree<T2> constructEmptyBinaryTree() {
//		return new EmptyBinaryTree<T2>();
//	}
	
	public int size() {
		return 0;
	}

	public BinaryTree<T> insert(T data) {
		return new NonEmptyBinaryTree<T>(data);
	}

	@Override
	public int height() {
		return -1;
	}

	@Override
	public String show() {
		return "";
	}

	@Override
	public BinaryTree<T> remove(T data) {
		return this;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	@Override
	public T biggest() {
		return null;
	}

	@Override
	public String treeshow() {

		return " ";
	}

	@Override
	public boolean elementOf(T d) {
		return false;
	}

	@Override
	public int balanceFactor() {
		return 0;
	}

	@Override
	public boolean avlBalanced() {
		return true;
	}
}
