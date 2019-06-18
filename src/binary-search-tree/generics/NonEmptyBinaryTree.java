package generics;

/**
 * NonEmptyBinaryTree - this is a binary search tree that is either an inner node
 * of the tree or a leaf node.  Leaf nodes will have 2 empty nodes attached to 
 * the right and the left subtrees.  Note that the insert and remove operation return 
 * the changed tree and they will generally modify existing trees. 
 * 
 * 
 * @author Eric McCreath - GPLv2
 */


public class NonEmptyBinaryTree<T extends Comparable<T>> extends BinaryTree<T> {
	T data;
	BinaryTree<T> left, right;
	
	public NonEmptyBinaryTree(T data) {
		this.data = data;
		left = new EmptyBinaryTree<T>();
		right = new EmptyBinaryTree<T>();
	}
	
	public NonEmptyBinaryTree(T data, BinaryTree<T> left, BinaryTree<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	public BinaryTree insert(T d) {
		int c = d.compareTo(data);

		if (c == 0) {
			return this;
		} else if (c == -1) {
			return new NonEmptyBinaryTree(data, left.insert(d), right);
		} else {
			return new NonEmptyBinaryTree(data, left, right.insert(d));
		}
	}
	
	public int size() {
		return 1 + left.size() + right.size();
	}

	@Override
	public int height() {
		return 1 + Math.max(left.height(), right.height());
	}

	@Override
	public String show() {
		if (left.isEmpty() && right.isEmpty()) return data + "";
		else return data + " (" + left.show() + "," + right.show() + ")";
	}

	@Override
	public BinaryTree remove(T d) {
		int c = d.compareTo(data);
		
		if (c == 0) {
			if (left.isEmpty()) return right;
			else if (right.isEmpty()) return left;
			else {
				T b = left.biggest();
				return new NonEmptyBinaryTree<T>(b, left.remove(b), right);
			}
		} else if (c == -1) {
		    return new NonEmptyBinaryTree<T>(data, left.remove(d), right);
		} else {
		    return new NonEmptyBinaryTree<T>(data, left, right.remove(d));
		}
	}

	@Override
	public boolean isEmpty() {
		return false;
	}

	@Override
	public T biggest() {
        if (right.isEmpty()) return data;
        else return right.biggest();
	}

	@Override
	public String treeshow() {
		if (left.isEmpty() && right.isEmpty()) return " " + data + " ";
		String stl = left.treeshow();
		String str = right.treeshow();
		String stal[] = stl.split("\n");
		String star[] = str.split("\n");
		int lenl = stal[0].length();
		int lenr = star[0].length();
		StringBuffer res = new StringBuffer();
		String strdata = data + "";
		int fullsize = lenl + strdata.length() + lenr;
		
	
		res.append(repeat(" ", (lenl)) + strdata + repeat(" ", lenr ) + "\n");
		int lcentre = (left.isEmpty() ? 0 : centre(stal[0]));
		int rcentre = (right.isEmpty() ? 0 :centre(star[0]));
		
		res.append(repeat(" ",lcentre) + "+" + repeat("-",lenl-lcentre-1) + "+" + repeat("-",rcentre-1+strdata.length()) +  "+" + repeat(" ",lenr-rcentre -1) + "\n");
		res.append(repeat(" ",lcentre) + (left.isEmpty()? " " : "|") + repeat(" ",lenl-lcentre-1) +  repeat(" ",rcentre + strdata.length()) +  (right.isEmpty()? " " : "|") + repeat(" ",lenr-rcentre-1) +"\n");
		
		for(int i = 0;i<Math.max(stal.length, star.length);i++) {
			res.append( (i<stal.length ? stal[i] : repeat(" ", lenl)) +repeat(" ",strdata.length()) +  (i<star.length? star[i] : repeat(" ", lenr)) + "\n");
		}
		return res.toString();
	}

	protected int centre(String string) {
		int i = 0;
		while (i < string.length() && string.charAt(i) == ' ') i++;
		return i;
	}

	protected String repeat(String string, int n) {
		String res = "";
		for (int i = 0; i<n;i++) res += string;
		return res;
	}

	@Override
	public boolean elementOf(T d) {
		int c = d.compareTo(data);

		if (c == 0) return true;
		else if (c == -1) return left.elementOf(d);
		else return right.elementOf(d);
	}

	@Override
	public int balanceFactor() {
		return left.height() - right.height();
	}
	
	public boolean avlBalanced() {
		return -1 <= balanceFactor() && balanceFactor() <= 1 && left.avlBalanced() && right.avlBalanced();
	}
	
	
	
	
	
}
