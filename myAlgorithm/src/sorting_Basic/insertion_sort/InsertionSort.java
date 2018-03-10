package sorting_Basic.insertion_sort;

import sorting_Basic.selection_sort.SelectionSort;
import utils.SortTestHelper;

public class InsertionSort {
	
	private InsertionSort(){}
	
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		for(int i=0; i<n; i++){
			//寻找元素arr[i]合适的插入位置
			for(int j=i; j>0; j--){
				if(arr[j].compareTo(arr[j-1])<0)
					swap(arr, j, j-1);
				else
					break;
			}
		}
	}
	
	public static void swap(Object[] arr, int i, int j){
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
		
	}
	
	public static void main(String[] args){
		int N = 20;
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 20);
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		
		InsertionSort.sort(arr);
		System.out.println("插入排序后的数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
	}
	

}
