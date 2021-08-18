package divide_and_conquer;

import java.util.Arrays;

public class BinarySearchTest {

    public static void main(String[] args) {

        int[] arr = {10, 4, 6, 20, 35, 7};
        Arrays.sort(arr);  // 값들을 오름차순 정렬

        System.out.println(binarySearch(arr, 6));
        System.out.println(binarySearch(arr, 35));
        System.out.println(binarySearch(arr, 50));

        System.out.println(Arrays.binarySearch(arr, 6));
        System.out.println(Arrays.binarySearch(arr, 35));
        System.out.println(Arrays.binarySearch(arr, 50));

    }

    private static int binarySearch(int[] arr, int key) {

        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;  // 중간 위치

            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        // 못찾았다면
        return -1;
    }
}
