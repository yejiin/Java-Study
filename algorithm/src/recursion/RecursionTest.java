package recursion;

public class RecursionTest {

    static int arr[] = {10, 20, 30};
    static int arr2[][] = {{11, 12, 13}, {20, 30, 40}};

    public static void main(String[] args) {
//        printArray();
//        printArrayRecursion(0);
//        printRowArray();
        printRowArrayRecursion(0, 0);
    }

    private static void printArray() {
        for(int i=0;i < arr.length; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }

    private static void printArrayRecursion(int num) {

        if (num == arr.length)
            return;

        System.out.print(arr[num] + "\t");
        printArrayRecursion(num + 1);

    }

    private static void printRowArray() {
        for (int i=0; i <arr2.length; i++) {
            for (int j =0; j <arr2[i].length;j++){
                System.out.print(arr2[i][j] + "\t");
            }
            System.out.println();
        }
    }

    private static void printRowArrayRecursion(int r, int c) {

        if (c==arr2[0].length) {
            System.out.println();
            return;
        }

        System.out.print(arr2[r][c] + "\t");
        printRowArrayRecursion(r, c+1);
        System.out.print(arr2[r+1][arr2[0].length - 1 - c] + "\t");

    }

}
