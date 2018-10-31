package com;

public class TestingSorting {

    public static void main(String[] args) {

//        System.out.println("_________selection sort__________________");
            Sorting s = new Sorting();
//        int[] array = new int[]{4, 1, 3, 5, 7, 9, 2, 8};
//        int[] temp = s.selectionSort(array);
//        for (int i = 0; i < array.length; i++) {
//            //System.out.println("here");
//            System.out.println(temp[i]);
//        }
        System.out.println("__________merge sort__________________");
        int[] array2 = new int[]{4, 1, 3, 5, 7, 9, 2, 8};
        int[] temp2 = s.mergeSort(array2);
        for (int i = 0; i < array2.length; i++) {
            //System.out.println("here");
            System.out.println(temp2[i]);
        }
//        System.out.println("___________quick sort_________________");
//        int[] array3 = new int[]{4, 1, 3, 5, 7, 9, 2, 8};
//        int[] temp3 = s.quickSort(array3);
//        for (int i = 0; i < array3.length; i++) {
//            //System.out.println("here");
//            System.out.println(temp3[i]);
//        }
    }
}
