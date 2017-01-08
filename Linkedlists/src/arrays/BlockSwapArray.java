package arrays;

import java.util.Arrays;

public class BlockSwapArray {
	 
    public static void main(String[] args) {
        int[] array;
        int size = 17;
        array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        System.out.println(Arrays.toString(array));
        rotateLeft(array, 7);
        System.out.println(Arrays.toString(array));
        System.out.println("DONE");
 
    }
 
    public static void rotateLeft(int[] arr, int d) {
        rotate(arr, 0, arr.length, d, arr.length - d);
    }
 
    public static void rotate(int[] arr, int start, int end, int m, int n) {
        System.out.println(Arrays.toString(arr) + " #" + start + " #" + end + " #" + m + " #" + n);
 
        if(m==n){
            blockSwap(arr, start, end - m, n);
            return;
        }
        if (m < n) {
            blockSwap(arr, start, end - m, m);
            rotate(arr, start, end - m, m, n - m);
        } else {
            blockSwap(arr, start, end - n, n);
            rotate(arr, start + n, end, m - n, n);
        }
    }
 
    private static void blockSwap(int[] arr, int l, int r, int size) {
        for (int i = 0; i < size; i++) {
            swap(arr, l + i, r + i);
        }
    }
 
    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}