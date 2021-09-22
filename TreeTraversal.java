//Do pre-order and post-order traversal in an array.
//Formula: The children of array[k] are array[2k] and array[2k+1]

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TreeTraversal {
/*
 * Complete the function below.
 */
    

    static void traverse(String order, int rootIndex, int[] treeArr) {
        if (rootIndex >= treeArr.length || rootIndex < 1) {
            System.out.println("Invalid");
            return;
        }
        if (order.equalsIgnoreCase("pre")) {
            preOrder(rootIndex, treeArr);
        } else {
            Stack<Integer> st = new Stack<Integer>(); 
            postOrder(rootIndex, treeArr, st);
        }
    }
    private static void postOrder(int rootIndex, int[] treeArr, Stack<Integer> st ) {
        if (rootIndex >= treeArr.length) {
                return;
        }
        st.add(treeArr[rootIndex]);
        postOrder((2 * rootIndex), treeArr, st);
        postOrder((2 * rootIndex) + 1, treeArr, st);
        System.out.println(st.pop());
       return;
    }
    private static void preOrder(int rootIndex, int[] treeArr) {
        if (rootIndex >= treeArr.length) {
            return;
        }
        System.out.println(treeArr[rootIndex]);
        preOrder((2 * rootIndex), treeArr);
        preOrder((2 * rootIndex) + 1, treeArr);
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String _order;
        try {
            _order = in.nextLine();
        } catch (Exception e) {
            _order = null;
        }
        
        int _rootIndex = Integer.parseInt(in.nextLine().trim());
        int _treeArr_size = Integer.parseInt(in.nextLine().trim());
        int[] _treeArr = new int[_treeArr_size];
        for(int _treeArr_i = 0; _treeArr_i < _treeArr_size; _treeArr_i++) {
            _treeArr[_treeArr_i] = Integer.parseInt(in.nextLine().trim());
        }
        
        traverse(_order, _rootIndex, _treeArr);
    }
}