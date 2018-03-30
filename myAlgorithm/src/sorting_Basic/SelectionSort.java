package sorting_Basic;

import utils.SortTestHelper;

/**
 * 
    * @ClassName: SelectionSort  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author dongxiao  
    * @date 2018年3月8日  
    *
 */
public class SelectionSort {
	
	private SelectionSort(){};	// 外部不能产生本类的实例  （反射呢？）
	
	/**
	 *    
	    * @Title: sort  
	    * @Description: TODO(选择排序的核心代码)  
	    * @param @param arr
	    * @return void
	    * @throws
	 */
	public static void sort(Comparable[] arr){
		
		int n = arr.length;
		for(int i = 0;i < n;i++){
			
			int minIndex = i;
			//
			for(int j = i+1;j<n;j++){
				if(arr[j].compareTo(arr[minIndex])<0)
					minIndex = j;
			}
			
			swap(arr,i,minIndex);
			
		}
	}
	
	/**
	 * 
	    * @Title: swap  
	    * @Description: TODO(交换数组中两个元素的位置)  
	    * @param @param arr
	    * @param @param i 
	    * @param @param j
	    * @return void
	    * @throws
	 */
	public static void swap(Object[] arr, int i, int j){
		Object t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args){
		
		//手动写测试用例
		Integer[] arr = {3,4,8,2,6,9,1,10,7,5};
		SelectionSort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		
		
		return;
		
	}

}
