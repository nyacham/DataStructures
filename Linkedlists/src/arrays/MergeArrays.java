package arrays;

public class MergeArrays {
	
	
	public static void main(String[] args) {
		int[] mPlusN = {10,20,-1,-1};
		int[] n = {4,10};
		mergeArrays(mPlusN,n);
	}

	private static void mergeArrays(int[] mPlusN, int[] n) {
		moveToEnd(mPlusN);
		merge(mPlusN,n);
	}
	



	private static void merge(int[] mPlusN, int[] n) {
		
	}

	private static void moveToEnd(int[] mPlusN) {
		int j =mPlusN.length-1;
		for (int i = mPlusN.length-1; i >= 0; i--) {
				if(mPlusN[i]!=-1){
					mPlusN[j] = mPlusN[i];
					j--;
				}
		}
				
		
	}
}