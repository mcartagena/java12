package com.mcartagena.learnjava.io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class SelectedSort {
	public static void main(String[] args){
		var systemIn = new BufferedReader(
			new InputStreamReader(
				System.in
				)); 
		int[] listToSort = new int[5];

		System.out.format("Enter %d numbers to sort: ", 5);

		try{
			String str = systemIn.readLine();			
			String[] strToSort = str.split("\\s");

			if(strToSort.length != 5)
				throw new RuntimeException("invalid size of numbers");

			for(int index = 0;index < strToSort.length; index++){
				listToSort[index] = Integer.parseInt(strToSort[index]);
			}
			System.out.format("Your text is: %s", Arrays.toString(listToSort));			
		} catch(IOException io){
			io.printStackTrace();
		}

		selectedSort(listToSort);

		System.out.format("Your numbers are: %s", Arrays.toString(listToSort));			

	}

	public static void swap(int[] array, int source, int target){
		int temp = array[source];
		array[source] = array[target];
		array[target] = temp;
	}

	public static void selectedSort(int[] array){
		for(int lastIndex = array.length ; lastIndex > 0; lastIndex--){
			int gratherIndex = 0;
			for(int index = 0; index < lastIndex ; index++){
				if(array[index] > array[gratherIndex]){
					gratherIndex = index;
				}
			}
			swap(array,gratherIndex,lastIndex - 1);
		}

	}
	
}