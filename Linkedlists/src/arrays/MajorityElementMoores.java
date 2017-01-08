package arrays;


/**
 * Majority Element finding with Time Complexity of O(n)
 * 
 * @author NIKHILESH
 *
 */
class MooresAlgorithm {

	static int findMajority(int[] a) {
		int majorityIndex = 0, count = 1;
		for (int i = 1; i < a.length; i++) {
			if (a[majorityIndex] == a[i]) {
				count++;
			} else {
				count--;
			}
			if (count == 0) {
				majorityIndex = i;
				count = 1;
			}
		}
		return a[majorityIndex];
	}

	static boolean hasMajority(int[] a, int candidate) {
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == candidate) {
				count++;
			}
		}
		if (count > a.length / 2) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] elements = { 4, 1, 3, 3, 1, 4 };
		int majority = findMajority(elements);
		System.out.println(majority);
		System.out.println(hasMajority(elements, majority));
	}
}

// This code has been contributed by Mayank Jaiswal
