package com.algorithm.sort;

/**
 * @author Liam Li
 * @date 2022/7/26
 * @Description
 */
public class heapSort {
    private static Comparable[] nums;  //final??  static??
    private static int N;

    public heapSort(int capacity) {
        nums = new Comparable[capacity + 1];
    }

    public static void sort(Comparable[] a){
        initMaxHeap(a);
        while (N >= 1) {
            exch(1, N--);
            sink(1);
        }
        for (int i = 0; i < a.length ; i++) {
            a[i] = nums[i+1];
        }
    }

    public static void initMaxHeap(Comparable[] a) {
        for (int i = 1; i <= a.length; i++) {
            nums[i] = a[i - 1];
        }
        N = a.length;
        for (int k = N/2; k >= 1; k--)  sink(k);
    }

    public static void swim(int k) {
        while(k / 2 >= 1) {
            int parent = k / 2;
            if(nums[parent].compareTo(nums[k]) < 0) {
                exch(parent, k);
                k = parent;
            }
            else break;
        }
    }

    public static void sink(int k) {
        while(k * 2 <= N) {
            int child = 2 * k;
            if (child < N && (nums[child].compareTo(nums[child+1]) < 0)) child++;
            if (nums[k].compareTo(nums[child]) < 0) {
                exch(k, child);
                k = child;
            }
            else break;
        }
    }


    public static void exch(int i, int j) {
        Comparable temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] a = {3,3,3,4,1,6,7,8,5,8,9,99};
        heapSort hs = new heapSort(a.length);
        hs.sort(a);
        for(int i:a) System.out.println(i);
    }
}
