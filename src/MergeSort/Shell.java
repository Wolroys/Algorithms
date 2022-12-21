package MergeSort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Shell {
    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 2, 0, -1, 6, 10, 22, 5, 3};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void shellSort(int[] arr){
        int inner, outer;
        int temp;
        int h = 1;
        while (h <= arr.length / 3){
            h = h * 3 + 1;
        }

        while (h > 0){
            for (outer = h; outer < arr.length; outer++){
                temp = arr[outer];
                inner = outer;
                while (inner >= h - 1 && arr[inner-h] >= temp){
                    arr[inner] = arr[inner-h];
                    inner -= h;
                }
                arr[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}
