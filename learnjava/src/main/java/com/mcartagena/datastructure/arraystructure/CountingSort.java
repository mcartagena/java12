package com.mcartagena.datastructure.arraystructure;


import java.util.Arrays;

public class CountingSort {
	public static void main(String[] args){
		var console = System.console();
		if(console == null){
			System.out.println("Console is not available...");
		}
		System.out.println("Enter 10 numbers between 1-10 separated by space:");
		String userInput = console.readLine();
		String[] arrayStr = userInput.split("\\s");
		int[] arrayInt = new int[10];
		for(int index = 0;index<arrayStr.length;index++){
			arrayInt[index] = Integer.parseInt(arrayStr[index]);
		}

		countingSort(arrayInt,1,10);

		System.out.println("The array sorted is:" + Arrays.toString(arrayInt));
	}

	public static void countingSort(int[] array, int start, int end){
		int[] countArray = new int[(end-start)+1];
		for(int index=0;index<array.length; index++){
			countArray[array[index]-1]++;
		}
		int indexSort = 0;
		for(int index=0;index<countArray.length;index++){
			while(countArray[index] > 0){
				array[indexSort++] = index + 1;
				countArray[index]--;
			}
		}
	}
}