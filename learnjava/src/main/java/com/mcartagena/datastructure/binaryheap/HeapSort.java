package com.mcartagena.datastructure.binaryheap;

public class HeapSort<T extends Comparable> extends Heap<T> {

    public static void main(String[] aStrings) throws HeapFullException, HeapEmptyException{
        HeapSort<Integer> heapSort = new HeapSort<>(Integer.class);
        
        heapSort.insert(4);
        heapSort.insert(6);
        heapSort.insert(9);
        heapSort.insert(2);
        heapSort.insert(10);
        heapSort.insert(56);
        heapSort.insert(12);
        heapSort.insert(5);
        heapSort.insert(1);
        heapSort.insert(17);
        heapSort.insert(14);

        heapSort.printHeapArray();
        heapSort.heapsort();
        heapSort.printHeapArray();

    }
    public HeapSort(Class<T> clazz) {
        super(clazz);
    }

    public HeapSort(Class<T> clazz, int size) {
        super(clazz, size);
    }    

    @Override
    protected void siftDown(int index) {
        System.out.println("siftDown method");
    }

    @Override
    protected void siftUp(int index)  {
        System.out.println("siftUp method");
    }

    private int getParentIndex(int index, int endIndex) {
        if (index < 0 || index > endIndex) {
            return -1;
        }

        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index, int endIndex) {
        int leftChildIndex = 2 * index + 1;
        if (leftChildIndex > endIndex) {
            return -1;
        }

        return leftChildIndex;
    }

    private int getRightChildIndex(int index, int endIndex) {
        int rightChildIndex = 2 * index + 2;
        if (rightChildIndex > endIndex) {
            return -1;
        }

        return rightChildIndex;
    }
    
    private void percolateDown(int index, int endIndex) {
        int leftChildIndex = getLeftChildIndex(index, endIndex);
        int rightChildIndex = getRightChildIndex(index, endIndex);

        if (leftChildIndex != -1 && getElementAtIndex(leftChildIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(leftChildIndex, index);
            percolateDown(leftChildIndex, endIndex);
        }
        if (rightChildIndex != -1 && getElementAtIndex(rightChildIndex).compareTo(getElementAtIndex(index)) > 0) {
            swap(rightChildIndex, index);
            percolateDown(rightChildIndex, endIndex);
        }
    }

    public void heapify(int endIndex) {
        int index = getParentIndex(endIndex, endIndex);
        while (index >= 0) {
            percolateDown(index, endIndex);
            index--;
        }
    }

    public void heapsort() {
        
        heapify(longArray() - 1);

        int endIndex = longArray() - 1;
        while (endIndex > 0) {
            swap(0, endIndex);
            endIndex--;
            percolateDown(0, endIndex);
        }
    }    

}