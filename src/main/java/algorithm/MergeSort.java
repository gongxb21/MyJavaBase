package algorithm;

import java.util.Arrays;

/**
 * 归并排序算法
 * @author gongxb
 * @date 2017-9-26  新建
 * 这个算法有两点是可以优化的
 * 1、在归并之前判断arr[mid]<arr[mid+1],对于趋于有序的序列有较大的提高
 * 2、所有的高级算法，都可以在一定的时候（趋于有序）引入插入排序
 * 
 * 
 * 
 */
public class MergeSort {
	private static int[] genernateArrays(int size,int range){
		int[] arr=new int[size];
		for(int i=0;i<size;i++){
			arr[i]=(int)Math.floor(Math.random()*range)+1;
		}
		return arr;
	}
	
	private static void printArray(int[] arr){
		for(int i: arr){
			System.out.print(i+"   ");
		}
	}
	public static void main(String[] args) {
		int[] arr=genernateArrays(10, 10);
		printArray(arr);
		System.out.println();
		sort(arr, 0, arr.length-1);
		
	}
	// 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort(int[] arr, int l, int r) {

        if (l >= r) {
        	
        	return;
        }

        int mid = (l+r)/2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    } 
    private static void merge(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r+1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){

            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l]<(aux[j-l])  ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
        printArray(arr);
        System.out.println();
    }
}

