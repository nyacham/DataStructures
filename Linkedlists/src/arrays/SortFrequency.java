package arrays;

import java.util.HashMap;
import java.util.Map;

public class SortFrequency {

	public static void main(String[] args) {
		int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
		printSortedByFrequency(arr);
	}

	private static void printSortedByFrequency(int[] arr) {
		sortArray(arr);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < arr.length; i++) {
			if(map.containsKey(arr[i])){
				Integer value = map.get(arr[i]);
				map.put(arr[i], value+1);
			}else{
				map.put(arr[i], 1);
			}
		}
		
	}

	private static void sortArray(int[] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i+1; j < a.length; j++) {
				if(a[i]>a[j]){
					int temp = a[i];
					a[i]=a[j];
					a[j]=temp;
				}
			}
		}
	}
}
