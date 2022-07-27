package com.algorithm.sort;

/**
 * @author Liam Li
 * @date 2022/7/26
 * @Description
 */
public class QuickSort {

    public static void sort(Comparable[] a) {
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if(hi <= lo)    return;
        int i = partition(a, lo, hi);
        sort(a, lo, i-1);
        sort(a, i+1, hi);
    }

    public static int partition(Comparable[] a, int lo, int hi) {
        Comparable v = a[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (i < hi) if (a[++i].compareTo(v) > 0) break;
            while (j > lo) if (a[--j].compareTo(v) < 0) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, j, lo);
        return j;
    }

    public static void exch (Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public static void main(String[] args) {
        Integer[] a = {3,3,3,4,1,6,7,8,5,8,9,99};
        sort(a);
        for(int i:a) System.out.println(i);
    }
}
