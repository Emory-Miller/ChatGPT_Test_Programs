import java.util.Arrays;

public class ArrayDeDup {
    public static <T> T[] deDup(T[] arr) {
        int n = arr.length;
        T[] dedupedArr = (T[])new Object[n]; // Create array of type T, not Object
        int count = 0;

        for (int i = 0; i < n; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (arr[i].equals(arr[j])) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                dedupedArr[count++] = arr[i];
            }
        }

        return Arrays.copyOf(dedupedArr, count);
    }

    public static void main(String[] args) {
        String[] arr = {"apple", "banana", "apple", "grape", "banana", "orange"};
        String[] dedupedArr = deDup(arr);

        System.out.println("Original array: " + Arrays.toString(arr));
        System.out.println("De-duplicated array: " + Arrays.toString(dedupedArr));
    }
}




