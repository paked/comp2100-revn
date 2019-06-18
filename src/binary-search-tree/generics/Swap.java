package generics;

import java.util.ArrayList;

public class Swap {
	public static <T> void swap(ArrayList<T> arr, int a, int b) {
		T temp = arr.get(a);
		arr.set(a, arr.get(b));
		arr.set(b, temp);
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<>();
		arr.add(10);
		arr.add(20);
		arr.add(30);
		arr.add(42);
		
		System.out.println(arr);
		
		swap(arr, 1, 2);
		
		System.out.println(arr);
	}
}
