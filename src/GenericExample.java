
import java.util.HashSet;

public class GenericExample {
    public static <T> T[] removeDuplicates(T[] arr) {
        HashSet<T> set = new HashSet<T>();
        for (T t : arr) {
            set.add(t);
        }

        // create an array of the same type as arr
        @SuppressWarnings("unchecked")
        T[] newArray = (T[]) java.lang.reflect.Array.newInstance(arr.getClass().getComponentType(), set.size());

        int i = 0;
        for (T t : set) {
            newArray[i++] = t;
        }

        return newArray;
    }

    public static void main(String[] args) {
        String[] arr = {"Dog" , "Cat", "Cat", "Dog", "Bunny" ,};
        String[] newArray = removeDuplicates(arr);

        System.out.println("The array with no duplicates: ");
        for (int i = 0; i < newArray.length; i++) {
            System.out.print(newArray[i] + " ");
        }
    }
}