package arrays;

public class InversionCount {

	public static void main(String[] args) {
		int arr [] =    {2, 4, 1, 3, 5};//{1,2,3,4,5}
		//{2,1},{4,1},{4,3}
		getInversionPairsN2(arr);
	}

	private static void getInversionPairsN2(int[] arr) {
		for (int i = 0; i < arr.length; i++) {	
			for (int j = 	i+1; j < arr.length; j++) {
				if(arr[j]<arr[i]){
					System.out.print("("+arr[i]+", "+arr[j]+")");
				}
			}
		}
	}
}
