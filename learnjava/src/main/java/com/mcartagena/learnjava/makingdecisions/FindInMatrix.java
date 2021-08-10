package com.mcartagena.learnjava.makingdecisions;

public class FindInMatrix {
    public static void main(String[] args) {
        int[][] list = {{1,13},{5,2},{2,2}};
        int searchValue = 2;
        int positionX = -1;
        int positionY = -1;

        PARENT_LOPP: for (int i=0; i<list.length;i++){
            System.out.println("Parent index: " +i);
            for (int j=0;j<list[i].length;j++){
                if(list[i][j]==searchValue){
                    positionX = i;
                    positionY = j;
                    System.out.println("jumpint to PARENT_LOPP");
                     break PARENT_LOPP;
//                    break;
                }
            }
        }

        if(positionX==-1 || positionY ==-1){
            System.out.println("Value "+searchValue+" not found");
        } else {
            System.out.println("Value " + searchValue + " fount at: " +
                    "(" + positionX + "," + positionY + ")");
        }
    }
}
