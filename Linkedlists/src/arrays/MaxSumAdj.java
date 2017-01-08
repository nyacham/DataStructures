package arrays;

public class MaxSumAdj {
	
	public static void main(String[] args) {
		int a[]= {3, 2, 7, 10};
		System.out.println(getMaxSum(a));
	}

	private static int getMaxSum(int[] a) {
		int evenSum = 0;
		int oddSum = 0;
		for (int i = 0; i < a.length; i++) {
			if(i%2==0){
				evenSum+=a[i];
			}else{
				oddSum+=a[i];
			}
		}
		return (evenSum>oddSum?evenSum:oddSum);
	}

}
