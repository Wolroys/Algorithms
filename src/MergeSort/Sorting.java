package MergeSort;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] arr = {5, 2, 19, 0, 1, 10, 6, 5, 7};
        fastSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr){
        int[] tempArr = new int[arr.length];
        recMergeSort(arr, tempArr, 0, arr.length - 1);
    }

    private static void recMergeSort(int[] arr, int[] tempArr, int lowerBound, int upperBound){
        if (lowerBound == upperBound)
            return;

        int mid = (lowerBound + upperBound) / 2;

        recMergeSort(arr, tempArr, lowerBound, mid);
        recMergeSort(arr, tempArr, mid+1, upperBound);
        merge(arr, tempArr, lowerBound, mid+1, upperBound);

    }

    private static void merge(int[] arr, int[] temp, int lowPtr, int highPtr, int upperBound){

        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound){
            if (arr[lowPtr] < arr[highPtr])
                temp[j++] = arr[lowPtr++];
            else
                temp[j++] = arr[highPtr++];
        }

        while (lowPtr <= mid){
            temp[j++] = arr[lowPtr++];
        }

        while (highPtr <= upperBound)
            temp[j++] = arr[highPtr++];

        for (int i = 0; i < n; i++){
            arr[lowerBound+i] = temp[i];
        }
    }

    public static void fastSort(int[] arr){
        recFastSort(arr, 0, arr.length - 1);
    }

    public static void recFastSort(int[] arr, int lowerBound, int upperBound){

        if (arr.length == 0)
            return;

        if (lowerBound >= upperBound)
            return;

        int mid = lowerBound + (upperBound - lowerBound)  / 2;
        int middleEl = arr[mid];
        int i = lowerBound;
        int j = upperBound;

        while (i <= j){
            while (arr[i] < middleEl)
                i++;

            while (arr[j] > middleEl)
                j--;

            if (i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }

            if (lowerBound < j)
                recFastSort(arr, lowerBound, j);

            if (i < upperBound)
                recFastSort(arr, i, upperBound);
        }

    }
}


