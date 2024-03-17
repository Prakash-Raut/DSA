package recursion;

public class ArraySortedCheck {
    public static boolean arraySortedOrNot(int[] arr) {
        return arraySortedOrNotHelper(arr,0);
    }

    private static boolean arraySortedOrNotHelper(int[] arr, int i) {
        if (i == arr.length - 1) return true;
        if (arr[i] > arr[i + 1]) return false;
        return arraySortedOrNotHelper(arr, i + 1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 0};
        System.out.println("arraySortedOrNot(arr) = " + arraySortedOrNot(arr));
    }
}
