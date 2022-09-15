package com.revature;

public class SepSixteenth {
	public static void main (String[] args) {
		/*int[] input = {515, 341, 98, 44, 211};
		String dir = "asc";*/
		
		/*int[] input = {515, 341, 98, 44, 211};
		String dir = "desc";*/
		
		/*int[] input = {63251, 78221};
		String dir = "asc";*/
		
		/*int[] input = {63251, 78221};
		String dir = "desc";*/
		
		int[] input = {1, 2, 3, 4};
		String dir = "asc";
		
		/*int[] input = {1, 2, 3, 4};
		String dir = "desc";*/
		
		for (int i: input) System.out.println(i);
		
		int[] output = reorderDigits(input, dir);
		
		for (int i: output) System.out.println(i);
		
		//int[] arr = {2, 8, 4, 1};
		
		//int[] arr = {-1, -10, 1, -2, 20};
		
		int[] arr = {-1, -20, 5, -1, -2, 2};
		
		System.out.println(canPartition(arr));
		
	}
	
	private static boolean canPartition (int[] arr) {
		int total = 1;
		
		for (int i : arr) total*=i;
		for (int i: arr) if (total/i == i) return true;
		return false;
	}
	
	private static int[] reorderDigits(int[] original, String dir) {
		if (!(dir.equals("asc")) && !(dir.equals("desc"))) {
			return new int[0];
		}
		
		else {
			
			for (int i = 0; i < original.length; i++) {
				
				if (dir.equals("asc")) original[i] = reorderMe(original[i], dir);
				else original[i] = reverse(reorderMe(original[i], dir));
			}
			
			return original;
		}
	}
	
	private static int reorderMe(int i, String dir) {
		if (i < 10) return i;
		else {
			String value = String.valueOf(i);
			int first = reorderMe((int) (i/Math.pow(10, value.length()/2)), dir);
			int second = reorderMe((int) (i%Math.pow(10, value.length()/2)), dir);
			
			boolean done = false;
			int pow = 0;
			int ordered = 0;
			
			while (!done) {
				int firstTail = first%10;
				int secondTail = second%10;
				
				if (firstTail > secondTail) {
					ordered+=firstTail * Math.pow(10 , pow);
					first/= 10;
				}
				else {
					ordered+=secondTail * Math.pow(10, pow);
					second/= 10;
				}
				pow++;
				if (first == 0 && second == 0) done = true;
				
			}
			
			return ordered;
		}
	}
	
	private static int reverse (int i) {
		int ordered = 0;
		
		while (i != 0) {
			ordered*= 10;
			ordered+= i%10;
			i/=10;
		}
		
		return ordered;
	}
}
