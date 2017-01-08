package sorting;

public class InsertionSort {

	public static void main(String[] args) {
		int a[] = { 12, 11, 13, 5, 6, 7 };
		insertionSort(a);
		customInsertionSort(a);
	}

	private static void customInsertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = i;
			while (temp > 0) {
				if (a[temp] < a[temp - 1]) {
					int tmp = a[temp];
					a[temp] = a[temp - 1];
					a[temp - 1] = tmp;
				}
				temp--;
			}
		}
	}

	private static void insertionSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int key = a[i];
			int j = i-1;
			while(j>=0 && a[j]>key){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = key;
		}
	}

}