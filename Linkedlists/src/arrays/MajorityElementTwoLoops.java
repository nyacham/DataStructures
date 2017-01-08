package arrays;

public class MajorityElementTwoLoops {

	public static void main(String[] args) {
		int[] elements = { 1, 2, 3, 4, 5, 6,5,5,5,5, 5};
		System.out.println(getMaxCount(elements));
	}

	public static int getMaxCount(int elements[]) {
		int maxCount = elements.length / 2;
		for (int i = 0; i < elements.length; i++) {
			int count = 0;
			for (int j = 0; j < elements.length; j++) {
				if (elements[i] == elements[j]) {
					count++;
				}
			}
			if (count > maxCount) {
				return elements[i];
			}
		}
		return -1;
	}
}
