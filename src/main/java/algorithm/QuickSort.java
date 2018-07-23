package algorithm;

public class QuickSort {
    private static int[] genernateArrays(int size, int range) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) Math.floor(Math.random() * range) + 1;
        }
        return arr;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + "   ");
        }
    }

    public static void sort(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(arr, l, r);
        sort(arr, l, p);
        sort(arr, p + 1, r);
        printArray(arr);
        System.out.println();

    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static int partition(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    public static void main(String[] args) {
        int[] arr = genernateArrays(10, 10);
        printArray(arr);
        System.out.println("++++++++++++");
        sort(arr, 0, arr.length - 1);
    }

}
