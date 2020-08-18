package com.mcartagena.datastructure.binaryheap;

public class MinHeap<T extends Comparable> extends Heap<T> {

    public static int[] randomNumberArray = new int[] {2, 5, 6, 21, 67, 88, 4, 1, 3, 9, 99};

    public static void main(String[] args) throws HeapFullException, HeapEmptyException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class);

        minHeap.insert(9);
        minHeap.insert(4);
        minHeap.insert(17);
        minHeap.printHeapArray();
        minHeap.insert(6);
        minHeap.printHeapArray();

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.printHeapArray();
        minHeap.insert(2);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.printHeapArray();

        minHeap.removeHighestPriority();
        minHeap.printHeapArray();
        minHeap.removeHighestPriority();
        minHeap.printHeapArray();

        int maxElement = getMaximum(minHeap);

        System.out.println("This the max Element in the minimum Heap: " + maxElement);

        printMaximumElements(minHeap);

        minHeap.printHeapArray();

        printMaximumKElements(3);
        printMaximumKElements(5);
        printMaximumKElements(6);        

    }    
    
    public MinHeap(Class<T> clazz){
        super(clazz);
    }
    public MinHeap(Class<T> clazz, int size){
        super(clazz, size);
    }

    @Override
    protected void siftDown(int index){
        int leftIndex = getLeftChildIndex(index);
        int rightIndex = getRightChildIndex(index);

        // Find the minimum of the left and right child elements
        int smallerIndex = -1;
        if(leftIndex!=-1 && rightIndex!=-1){
            smallerIndex = getElementAtIndex(leftIndex)
                           .compareTo(getElementAtIndex(rightIndex))<0?
                           leftIndex:rightIndex;
        } else if (leftIndex!=-1){
            smallerIndex = leftIndex;
        } else if (rightIndex!=-1){
            smallerIndex = rightIndex;
        }

        // If the left and right child do not exist stop sifting down
        if(smallerIndex==-1){
            return;
        }

        // Compare the smaller child with the current index to see if 
        // a swap and further sift down is needed
        if(getElementAtIndex(smallerIndex)
           .compareTo(getElementAtIndex(index))<0){
               swap(smallerIndex, index);
               siftDown(smallerIndex);
           }
    }

    @Override
    protected void siftUp(int index){
        int parentIndex = getParentIndex(index);

        if(parentIndex!=-1 && getElementAtIndex(index)
                       .compareTo(getElementAtIndex(parentIndex))<0){
                           swap(parentIndex, index);

                           siftUp(parentIndex);
                       }
    }

    public static int getMaximum(MinHeap<Integer> minHeap){
        int lastIndex = minHeap.getCount() - 1;
        int lastParentIndex = minHeap.getParentIndex(lastIndex);

        int firstChildIndex = lastParentIndex + 1;

        int maxElement = minHeap.getElementAtIndex(firstChildIndex);

        for (int i = firstChildIndex; i <= lastIndex; i++){
            if(maxElement < minHeap.getElementAtIndex(i)){
                maxElement =minHeap.getElementAtIndex(i);
            }
        }
        
        return maxElement;
    }

    public static void printMaximumElements(MinHeap<Integer> minHeap) throws HeapEmptyException, HeapFullException{
        
        for(int number : randomNumberArray){
            if(minHeap.isEmpty()){
                minHeap.insert(number);
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number){
                if(minHeap.isFull()){
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(number);
            }
        }

        return;
    }

    public static void printMaximumKElements(int k)
            throws MinHeap.HeapEmptyException, MinHeap.HeapFullException {
        MinHeap<Integer> minHeap = new MinHeap<>(Integer.class, k);

        for (int number : randomNumberArray) {
            if (minHeap.isEmpty()) {
                minHeap.insert(number);
            } else if (!minHeap.isFull() || minHeap.getHighestPriority() < number) {
                if (minHeap.isFull()) {
                    minHeap.removeHighestPriority();
                }
                minHeap.insert(number);
            }
        }

        minHeap.printHeapArray();
    }    
}