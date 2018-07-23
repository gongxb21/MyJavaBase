package algorithm;

public class TestOnBubbleSort {
    public static int[] change(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        return arr;
    }

    public static int[] genernateArray(int size, int range) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            int k = (int) Math.ceil(Math.random() * range) + 1;
            array[i] = k;
        }
        return array;
    }

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }

    }

    public static void main(String[] args) {
        int[] arr = genernateArray(10, 10);
        long start = System.currentTimeMillis();
        //arr=SelectionSort.SelectionSort(arr);
        arr = InsertSort.insertSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        printArr(arr);
    }

}
