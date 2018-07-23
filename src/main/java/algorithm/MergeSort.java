package algorithm;

import java.util.Arrays;

/**
 * �鲢�����㷨
 *
 * @author gongxb
 * @date 2017-9-26  �½�
 * ����㷨�������ǿ����Ż���
 * 1���ڹ鲢֮ǰ�ж�arr[mid]<arr[mid+1],������������������нϴ�����
 * 2�����еĸ߼��㷨����������һ����ʱ���������������������
 */
public class MergeSort {
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

    public static void main(String[] args) {
        int[] arr = genernateArrays(10, 10);
        printArray(arr);
        System.out.println();
        sort(arr, 0, arr.length - 1);

    }

    // �ݹ�ʹ�ù鲢����,��arr[l...r]�ķ�Χ��������
    private static void sort(int[] arr, int l, int r) {

        if (l >= r) {

            return;
        }

        int mid = (l + r) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // ��ʼ����iָ����벿�ֵ���ʼ����λ��l��jָ���Ұ벿����ʼ����λ��mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // �����벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // ����Ұ벿��Ԫ���Ѿ�ȫ���������
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < (aux[j - l])) {  // ��벿����ָԪ�� < �Ұ벿����ָԪ��
                arr[k] = aux[i - l];
                i++;
            } else {  // ��벿����ָԪ�� >= �Ұ벿����ָԪ��
                arr[k] = aux[j - l];
                j++;
            }
        }
        printArray(arr);
        System.out.println();
    }
}

