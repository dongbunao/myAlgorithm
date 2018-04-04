package heap;

import sorting_Advance.MergeSort;
import utils.SortTestHelper;

/**
 * 
    * @ClassName: HeapSort1  
    * @Description: TODO(堆排序的基础实现)  
    * @author dongxiao  
    * @date 2018年4月4日  
    *
 */
public class HeapSort1 {
	
	private HeapSort1(){}
	
	
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		MaxHeap<Comparable> maxHeap = new MaxHeap<Comparable>(n);
		
		for(int i=0; i<n; i++){
			maxHeap.insert(arr[i]);
		}
		
		for(int i=n-1; i>=0; i--){
			arr[i] = maxHeap.extractMax();
		}
	}

	public static void main(String[] args) {
		
		Integer[] arr = {3,4,8,2,6,9,1,1,7,5,1,22,13,44,23,4,66,54,32,17,16,15,14,21,23,19,17,16};
		
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		
		HeapSort1.sort(arr);
		System.out.println("堆排序后排序后的数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
		return;
	}

}
