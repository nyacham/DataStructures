package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = { 64, 25, 12, 22, 11 };
		selectionSort(arr);
		System.out.println();
	}

	private static void selectionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int minIdx = i;
			for (int j = i+1; j < a.length; j++) {
				if(a[j]<a[minIdx]){
					minIdx = j;
				}
			}
			int temp = a[i];
			a[i] = a[minIdx];
			a[minIdx] = temp;
 		}
	}
}
