package com.revature;

import java.util.Scanner;

public class WeekTwo {
	public static void main(String args[]) {
		
		Scanner in = new Scanner(System.in);
		
		int n = 0;
		
		int index = 0;
		
		int[] arr = {};
		
		while (n < 1) {
		
			System.out.println("How many integers do you wish to enter?");
			
			if (in.hasNextInt()) {
			
				n = in.nextInt();
				
				if (n > 0) {
				
					index = 0;
					
					arr = new int[n];
				}
				
				else {
					System.out.println("Choose a number above 0.");
				}
			}
			
			else {
				System.out.println("Please use an integer.");
			}
		}
		
		System.out.println("Please enter your integers");
		
		while (index < n){
			if (in.hasNextInt()) {
				arr[index]=in.nextInt();
				index++;
			}
			
			else if (in.hasNext()) System.out.println("Please use an integer.");
			
			else System.out.println("Please enter " + (n - index) + " more integers");
		}
		
		int diff = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = i +1; j < n; j++) {
				int currDiff = Math.abs(arr[i] - arr[j]);
				if (currDiff > diff) diff = currDiff;
			}
		}
		
		System.out.println(diff);
		
	}
}
