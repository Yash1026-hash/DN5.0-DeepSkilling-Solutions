 public class ArrayOperation {

    public static void traverse(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        traverse(arr);

    }
}