package algorithm;

public class SelectionSort {
	
	public static int[] SelectionSort( int[] array ) {
		for(int i=0;i<array.length;i++) {
			for(int j=i+1;j<array.length;j++) {
				if(array[i]>array[j]){
					array=TestOnBubbleSort.change(array, i, j);
				}
			}
		}
		return array;
	}

}
