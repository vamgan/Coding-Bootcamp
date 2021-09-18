//Merge sort array in descending order

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Mergesort {
 
   /*
   * Complete the function below.
   */


    static int[] MergeSort(int[] values) {
        helperMergeSort(values,0, values.length - 1);
        return values;
        
    }
    private static void helperMergeSort(int[] values, int l, int h) {
        if (h <= l) {
            return;
        }
        int mid = (l + h)/ 2;
        helperMergeSort(values, l, mid);
        helperMergeSort(values, mid+1, h);
        merge(values, l, mid, h);
    } 
    
    private static void merge(int[] array, int low, int mid, int high) {
        int leftArray[] = new int[mid - low + 1];
        int rightArray[] = new int[high - mid];
        for (int i = 0; i < leftArray.length; i++)
            leftArray[i] = array[low + i];
        for (int i = 0; i < rightArray.length; i++)
            rightArray[i] = array[mid + i + 1];
        int leftIndex = 0;
        int rightIndex = 0;
        for (int i = low; i < high + 1; i++) {
            if (leftIndex < leftArray.length && rightIndex < rightArray.length) {
                if (leftArray[leftIndex] > rightArray[rightIndex]) {
                    array[i] = leftArray[leftIndex];
                    leftIndex++;
                } else {
                    array[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            } else if (leftIndex < leftArray.length)  {
                array[i] = leftArray[leftIndex];
                leftIndex++;
            }  else if (rightIndex < rightArray.length) {
                array[i] = rightArray[rightIndex];
                rightIndex++;
            }
        }
    }


