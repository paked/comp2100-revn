package generics;

public class Pair<T1, T2 extends Number>{
    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    public T1 getKey() { return key; }
    public T2 getValue() { return value; }

    public void setKey(T1 key) { this.key = key; }
    public void setValue(T2 value) { this.value = value; }

    private T1 key;
    private T2 value;
    
    public static void main(String[] args) {
    	Pair<Integer, Integer> pair1 = new Pair<Integer, Integer>(2, 3);
    	System.out.println(pair1.getKey() + " " + pair1.getValue());

    	Pair<String, Double> pair2 = new Pair<String, Double>("hello", 4.3);
    	System.out.println(pair2.getKey() + " " + pair2.getValue());

//    	// Code below should raise a compile time error.
//    	Pair<String, String> pair3 = new Pair<String, String>("hello", "hi");  
//    	System.out.println(pair3.getKey() + " " + pair3.getValue());
    }
}