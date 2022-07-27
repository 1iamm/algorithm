package com.algorithm.sort;

/**
 * @author Liam Li
 * @date 2022/7/26
 * @Description
 */
public class Solution {

    public static void main(String[] args) {
        int[] a = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        minHeap mh = new minHeap();
        int ret = mh.kMinHeap(a, k);
        System.out.println(ret);
    }
}

class minHeap {
    private int[] heap;
    private int N;

    public int kMinHeap(int[] nums, int k) {
        this.N = k;
        this.heap = new int[N+1];
        int len = nums.length;
        for (int i = 1; i <= N; i++) this.heap[i] = nums[i-1];
        for (int i = N/2; i >= 1; i--)
            sink(i);
        if (len > N) {
            for (int i = N; i < len; i++) {
                if(heap[1] < nums[i]) {
                    heap[1] = nums[i];
                    this.sink(1);
                }
            }
        }
        return heap[1];
    }

    public void sink(int k) {
        while (k*2 <= this.N) {
            int i = 2 * k;
            if (this.N > i && this.heap[i+1] < this.heap[i]) i++;
            if (this.heap[k] > this.heap[i]) {
                this.exch(i,k);
                k = i;
            }
            else break;
        }
    }

    public void swim(int k) {
        int parent = k / 2;
        while (parent >= 1) {
            if (this.heap[parent] > this.heap[k]) {
                this.exch(parent, k);
                k = parent;
            }
            else break;
        }
    }

    public void exch(int i, int j) {
        int temp = this.heap[i];
        this.heap[i] = this.heap[j];
        this.heap[j] = temp;
    }
}
