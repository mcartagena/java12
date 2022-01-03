package com.mcartagena.learnjava.io;

import java.io.*;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arrayToSort = {55, 3, -15, 34, 21, -1, 0, 5};

        for (int lastSortedIndex = arrayToSort.length - 1; lastSortedIndex > 0; lastSortedIndex--) {
            for (int index = 0; index < lastSortedIndex; index++) {
                if (arrayToSort[index] > arrayToSort[index + 1]) {
                    swapArrayElement(arrayToSort, index, index + 1);
                }
            }
        }
        writeOrderArrayBinaryToDisk(arrayToSort);
        writeOrderArrayCharacterToDisk(arrayToSort);
    }

    public static void swapArrayElement(int[] array, int sourceIndex, int targetIndex) {
        int temp = array[sourceIndex];
        array[sourceIndex] = array[targetIndex];
        array[targetIndex] = temp;
    }

    public static void writeOrderArrayBinaryToDisk(int[] arrayToWrite) {
        try (var dataOutputStream = new DataOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream("sortedArray.bin")
                )
        )) {
            for (int index = 0; index < arrayToWrite.length; index++) {
                dataOutputStream.writeInt(arrayToWrite[index]);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    public static void writeOrderArrayCharacterToDisk(int[] arrayToWrite) {
        try (var bufferedWriter = new BufferedWriter(
                new FileWriter("sortedArray.txt")
        )) {
            for (int index = 0; index < arrayToWrite.length; index++) {
                bufferedWriter.write(String.valueOf(arrayToWrite[index]));
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
}
