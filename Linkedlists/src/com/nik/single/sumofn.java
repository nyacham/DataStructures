package com.nik.single;

public class sumofn {

	public static void main(String[] args) {
		System.out.println(sumRecursive(1));
	}

	static int sumRecursive(int n) {
		int i = 1;
		int sum =1;
		while(i<n){
			i++;
			sum = sum+i;
		}
		return sum;
	}

	static int iterativeSum(int n) {
		int i = 1;
		int sum = 1;
		while (i<n){
			i++;
			sum =sum+i;
		}
		return sum;
	}
	
	static int it(int n){
		int sum =0;
		for (int i = 1; i <=n; i++) {
			sum = sum+i;
		}
		return sum;
	}
}
