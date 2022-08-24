package com.revature;

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		
		int[] m = {1,2};
		int[] n = {3,4};
		
		//int[] m = {1,3};
		//int[] n = {2};
		
		//sort through the arrays
		
		int[] merged = new int[m.length + n.length];
		
		boolean done = false;
		
		int mIt = 0;
		int nIt = 0;
		int mergedIt = 0;
		
		while(!done) {
			// check if both iterators point to something
			
			//if both do, check for the smallest
			if (mIt < m.length && nIt < n.length) {
				if (m[mIt] <= n[nIt]) {
					merged[mergedIt] = m[mIt];
					mIt++;
				}
				else {
					merged[mergedIt] = n[nIt];
					nIt++;
				}
			}
			
			//if one does, add the one that does
			else if (mIt < m.length) {
				merged[mergedIt] = m[mIt];
				mIt++;
			}
			
			else if(nIt < n.length) {
				merged[mergedIt] = n[nIt];
				nIt++;
			}
			//if none do, we're done
			else {
				done = true;
			}
			
			mergedIt++;
			
		}
		
		
		//find median
		
		if (merged.length%2 == 1) System.out.println(merged[merged.length/2]);
		else {
			//add medians together as double
			double medianSum = merged[merged.length/2] + merged[merged.length/2-1];
			//divide by 2
			System.out.println(medianSum/2);
		}
		
		//stretch goal: specify problem number
		//stretch goal: format to expected format
		//stretch goal: take input from command line
		
		// ----------------------------------------------------------------------------------------------
		
		LinkedList<Integer>[] lists = new LinkedList[0];
		
		/*LinkedList<Integer>[] lists = new LinkedList[3];
		
		for (int i = 0; i < lists.length; i++) {
			lists[i]=new LinkedList<Integer>();
		}
		
		lists[0].add(1);
		lists[0].add(4);
		lists[0].add(5);
		lists[1].add(1);
		lists[1].add(3);
		lists[1].add(4);
		lists[2].add(2);
		lists[2].add(6);*/
		
		//get number of linked lists
		//set up an iterator for each
		ListIterator<Integer>[] listIts = new ListIterator[lists.length];
		
		for (int i = 0; i < lists.length; i++) {
			listIts[i] = lists[i].listIterator();
		}
		
		LinkedList<Integer> mergedTwo = new LinkedList<Integer>();
		//check through the iterators for the smallest number and add it
		int lowestIndex = -1;
		int lowestValue = -1;
		int bufferValue = -1;
		boolean doneTwo = false;
		
		while (!doneTwo) {
			doneTwo = true;
			for(int i = 0; i < lists.length; i++) {
				if (listIts[i].hasNext()) {
					doneTwo = false;
					bufferValue = listIts[i].next();
					listIts[i].previous();
					if (lowestIndex == -1 || bufferValue < lowestValue) {
						lowestIndex = i;
						lowestValue = bufferValue;
					}
				}
			}
			
			
			if (!doneTwo) {
				mergedTwo.add(lowestValue);
				listIts[lowestIndex].next();
			}
			
			lowestIndex = -1;
			lowestValue = -1;
			bufferValue = -1;
			
		}
		//when all of the iterators stop returning, stop
		//print the numbers
		for(int i: mergedTwo) {
			System.out.print(i + " ");
		}
	}
	
	
}