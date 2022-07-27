package com.algorithm.sort;

import java.util.Arrays;

/**
 * @author Liam Li
 * @date 2022/7/24
 * @Description
 */
public class QuickSort3Way {

    public static void sort(Comparable[] nums) {
        int len = nums.length;
        sort(nums, 0, len-1);
    }

    public static void sort (Comparable[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int lt = lo;
        int gt = hi;
        Comparable v = nums[lo];
        int i = lo + 1;
        while (i <= gt) {
            int cmp = nums[i].compareTo(v);
            if (cmp < 0) exch(nums, lt++, i++);
            else if (cmp > 0) exch(nums, i, gt--);
            else i++;
        }
        sort(nums, lo, lt-1);
        sort(nums, gt+1, hi);
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
