package sorting_Advance;

import sorting_Basic.InsertionSort;

/**
 * 
    * @ClassName: QuickSort3Ways  
    * @Description: TODO(三路快排的基础实现)  
    * @author dongxiao  
    * @date 2018年4月3日  
    *
 */
public class QuickSort3Ways {
	
	private QuickSort3Ways(){}
	
	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		sort (arr, 0, n-1);
	}

	private static void sort(Comparable[] arr, int l, int r) {
		
		// 数组规模较小的时候使用插入排序  
		if(r - l <= 15){
			InsertionSort.sort(arr, l, r);
			return;
		}
		
//		if(l >= r){
//			return;
//		}
		
		swap(arr, l, (int) (Math.random()*(r-l+1))+1);
		
		Comparable v = arr[l];
		
		int lt = l; //arr[l+1...lt]<t
		int gt = r; //arr[gt...r]>t
		int i = l+1; //arr[lt+1...i)=t
		
		while(i < gt){
			if(arr[i].compareTo(v)<0){
				swap(arr, i, lt+1);
				i++;
				lt++;
			}
			else if(arr[i].compareTo(v)>0){
				swap(arr, i, gt-1);
				i++;
				gt--;
			}
			else{
				i++;
			}
		}
		
		swap(arr, l, lt);
		
		sort(arr, l, lt-1);
		sort(arr, gt, r);
			
	}
	
	public static void swap(Comparable[] arr, int i, int j){
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	

	public static void main(String[] args) {
		
		Integer[] arr = {3,4,8,2,6,9,1,1,7,5,1,22,13,44,23,4,66,54,32,17,16,15,14,21,23,19,17,16};
		
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		
		MergeSort.sort(arr);
		System.out.println("3路快速排序后排序后的数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
		return;

	}

}
