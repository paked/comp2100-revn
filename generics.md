# Generic generics

`<? super X> consumers`

`<? extends X>`

_declaring a generic class_
`public abstract class BinaryTree<T extends Comparable<T>>`

_sublcass a generic class_
`public class EmptyBinaryTree<T extends Comparable<T>> extends BinaryTree<T>`

```
public static <T> void swap(ArrayList<T> arr, int a, int b) {
  T temp = arr.get(a);
  arr.set(a, arr.get(b));
  arr.set(b, temp);
}
```
