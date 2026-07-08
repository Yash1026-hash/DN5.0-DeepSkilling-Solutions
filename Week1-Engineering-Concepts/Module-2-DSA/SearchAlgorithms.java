public class SearchAlgorithms {

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
    // Array must be sorted
    public static int binarySearch(int[] arr, int target) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }

        }

        return -1;
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 30, 40, 50, 60, 70};

        int linearResult = linearSearch(arr, 40);
        System.out.println("Linear Search: Element found at index " + linearResult);

        int binaryResult = binarySearch(arr, 40);
        System.out.println("Binary Search: Element found at index " + binaryResult);

    }

}
