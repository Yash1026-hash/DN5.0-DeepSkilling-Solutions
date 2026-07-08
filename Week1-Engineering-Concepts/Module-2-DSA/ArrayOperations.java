public class ArrayOperations {

    // Traversal - O(n)
    public static void traverse(int[] arr) {
        System.out.print("Traversal: ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Linear Search - O(n)
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search - O(log n)
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    // Insert at End - O(n)
    public static int[] insert(int[] arr, int value) {

        int[] newArr = new int[arr.length + 1];

        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }

        newArr[arr.length] = value;

        return newArr;
    }

    // Delete by Value - O(n)
    public static int[] delete(int[] arr, int value) {

        int index = linearSearch(arr, value);

        if (index == -1) {
            return arr;
        }

        int[] newArr = new int[arr.length - 1];

        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                newArr[j++] = arr[i];
            }
        }

        return newArr;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50};

        traverse(arr);

        System.out.println("Linear Search (30): " + linearSearch(arr, 30));

        System.out.println("Binary Search (40): " + binarySearch(arr, 40));

        arr = insert(arr, 60);
        System.out.print("After Insert: ");
        traverse(arr);

        arr = delete(arr, 20);
        System.out.print("After Delete: ");
        traverse(arr);
    }
}