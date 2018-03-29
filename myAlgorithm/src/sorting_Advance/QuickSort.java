package sorting_Advance;

import sorting_Basic.InsertionSort;
import utils.SortTestHelper;

public class QuickSort {
	
	private QuickSort(){}
	
	/**
	 * 
	    * @Title: partition  
	    * @Description: TODO(对arr[l...r]部分进行partition操作)  
	    * @param @param arr
	    * @param @param l
	    * @param @param r
	    * @param @return
	    * @return p 使得 arr[l...p-1] < arr[p],arr[p=1...r] > arr[p]
	    * @throws
	 */
	public static int partition(Comparable[] arr, int l, int r) {
		
		// 随机选择一个元素作为基准点
		swap(arr, l, (int)(Math.random()*(r-l+1))+1);
		
		Comparable v = arr[l]; 
		
		int j = l;  //j 为选取的标定点v 在一轮循环后应该在的位置。arr[l+1...j] < v,arr[j+1...i) > v
		for(int i = l+1;i <= r; i++){
			if(arr[i].compareTo(v) < 0){
				j++;
				swap(arr, i, j);
			}
			swap(arr, l, j);
		}
		
		return j;
	}

	
	public static void swap(Comparable[] arr, int i, int j) {
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		
	}

	public static void sort(Comparable[] arr, int l, int r) {
		
		if(r-l < 15){
			InsertionSort.sort(arr, l, r);
			return;
		}
		
		int p = partition(arr, l, r);
		sort(arr, l, p-1);
		sort(arr, p+1, r);
	}

	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		sort(arr, 0, n-1);
	}
	

	public static void main(String[] args){
		int N = 10000;
		
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
		SortTestHelper.testSort("sorting_Advance.QuickSort", arr);
		
		return;
	}

}
