package arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = 1; i < 10; i++) {
			System.out.println(recursiveBinarySearch(a, i, 0, a.length - 1));
		}
		for (int i = 1; i < 10; i++) {
			System.out.println(iterativeBinarySearch(a, i));
		}
	}

	private static int recursiveBinarySearch(int[] a, int element, int l, int r) {
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == element) {
				return mid;
			} else if (a[mid] > element) {
				return recursiveBinarySearch(a, element, l, mid-1);
			} else {
				return recursiveBinarySearch(a, element, mid+1, r);
			}
		}
		return -1;
	}

	private static int iterativeBinarySearch(int[] a, int element) {
		int l = 0, r = a.length - 1;
		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == element) {
				return mid;
			} else if (element > a[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return -1;
	}

}