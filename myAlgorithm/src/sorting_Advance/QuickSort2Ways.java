package sorting_Advance;

import utils.SortTestHelper;

/**
 * 
    * @ClassName: QuickSort2Ways  
    * @Description: TODO(双路快速排序的基础实现)  
    * @author dongxiao  
    * @date 2018年3月30日  
    *
 */
public class QuickSort2Ways {
	
	private QuickSort2Ways(){}
	
	/**
	 * 
	    * @Title: partition  
	    * @Description: TODO 双路快排的partition  
	    * @param @param arr
	    * @param @param l
	    * @param @param r
	    * @param @return
	    * @return int j ,使得 arr[l...j-1] < arr[j],arr[j+1...r] > arr[j]
	    * @throws
	 */
	private static int partition(Comparable[] arr, int l, int r) {
		
		// 随机选择标定点
		swap(arr, l, (int) (Math.random()*(r-l+1)) +1 );
		
		Comparable v = arr[l];
		
		int i = l + 1, j = r;
		while(true){
			while(i<=r && arr[i].compareTo(v) < 0){
				i ++;
			}
			
			while(j>=l+i && arr[j].compareTo(v) > 0){
				j --;
			}
			
			if(i>=j){
				break;
			}
			
			swap(arr, i, j);
			i ++;
			j --;
		}
		
		swap(arr, l, j);
		
		return j;
	}


	
	private static void sort(Comparable[] arr, int l, int r) {
		
		if(l >= r){
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

	public static void swap(Comparable[] arr, int i, int j){
		Comparable t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

	public static void main(String[] args) {
		
		Integer[] arr = {3,4,8,2,6,9,1,1,7,5};
		
		System.out.println("原始数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		System.out.println();
		
		QuickSort2Ways.sort(arr);
		System.out.println("双路快速排序后的数组：");
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
		return;
	}

}
