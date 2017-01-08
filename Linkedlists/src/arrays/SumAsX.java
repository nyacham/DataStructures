package arrays;

import java.util.ArrayList;
import java.util.HashSet;


public class SumAsX {
	
	
	public static void printPairs(ArrayList<Integer> list, int sum){
		HashSet<Integer> set = new HashSet<Integer>();
		for (Integer integer : list) {
			Integer temp = sum  - integer;
			if(set.contains(temp)){
				System.out.println("("+integer+", "+temp+")");
			}
			set.add(integer);
		}
	}
	
	public static void main(String[] args) {
		getInteger("1234567890");
	}
	
	private static void getInteger(String numberStr){
		Double returnVal = 0.0;
		if(numberStr.matches("[0-9]+")){ 
			char[] charArray = numberStr.toCharArray();
			for (int i = 0; i < charArray.length; i++) {
				int numVal = charArray[i]-'0';
				returnVal = returnVal+numVal*Math.pow(10, charArray.length-i-1);
			}
			System.out.println(returnVal.intValue());
		}
	}
}
