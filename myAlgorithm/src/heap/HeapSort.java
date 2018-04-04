package heap;

/**
 * 
    * @ClassName: HeapSort  
    * @Description: TODO 不适用额外的最大堆，直接在原数组上进行原地的堆排序  
    * @author dongxiao  
    * @date 2018年4月4日  
    *
 */
public class HeapSort {
	
	private HeapSort(){}
	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		
		for(int i=(n-1-1)/2; i>=0; i--){
			shiftDown2(arr, n, i);
		}
		
		for(int i=n-1; i>0; i--){
			swap(arr, 0, i);
			shiftDown2(arr, i, 0);
		}
		
	}
	
	private static void swap(Comparable[] arr, int i, int j) {
		// TODO Auto-generated method stub
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	// 对 原始的shiftDown 进行了优化，优化思路和插入排序的优化一致
	private static void shiftDown2(Comparable[] arr, int n, int k){
		
		Comparable e = arr[k];
		while(2*k+1 < n){
			int j = 2*k+1;
			if(j+1<n && arr[j+1].compareTo(arr[j])>0){
				j = j+1;  //arr[j] 是 arr[k] 子元素中的最大值
			}
			
			if(e.compareTo(arr[j])>=0){
				break;
			}
			arr[k] = arr[j];
			k = j;
		}
		
		arr[k] = e;
	}
	

	public static void main(String[] args) {
		Integer[] arr = {3,4,8,2,6,9,1,1,7,5,1,22,13,44,23,4,66,54,32,17,16,15,14,21,23,19,17,16};
		
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		
		HeapSort.sort(arr);
		System.out.println("原地堆排序后排序后的数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
		return;

	}

}
