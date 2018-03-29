package sorting_Advance;

import java.util.Arrays;

import sorting_Basic.InsertionSort;
import utils.SortTestHelper;

/**
 * 
    * @ClassName: MergeSortBU  
    * @Description: TODO( 自底向上的归并排序的实现 )  
    * @author dongxiao  
    * @date 2018年3月29日  
    *
 */
public class MergeSortBU {
	
	private MergeSortBU(){}
	
	public static void merge(Comparable[] arr, int l, int mid, int r){
		
		Comparable[] aux = Arrays.copyOfRange(arr, l, r+1);
		
		//初始化，i指向左半部分的起始索引位置l，j指向右半部分的起始索引位置mid+1
		int i = l, j = mid+1;
		
		for(int k=l; k<=r; k++){
			if(i>mid){ //如果左半部分元素已经全部处理完毕
				arr[k] = aux[j-l];
				j++;
			}
			else if(j>r){
				arr[k] = aux[i-l];
				i++;
			}
			else if( aux[i-l].compareTo(aux[j-l]) < 0 ){
				arr[k] = aux[i-l];
				i++;
			}
			else{
				arr[k] = aux[j-l];
				j++;
			}
		}
		
	}
	
	
	public static void sort(Comparable[] arr){
		int n = arr.length;
		
		// MergeSort 自底向上的无优化版
//		for(int sz = 1; sz < n; sz*=2){
//			for(int i = 0; i < n-sz; i+=sz+sz){
//				merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
//			}
//		}
		
		// MergeSort 自底向上的 优化
		// 优化点一：对于小规模数组使用插入排序
		for(int i = 0; i < n; i+=16){
			InsertionSort.sort(arr, i, Math.min(i+15, n-1));
		}
		
		for(int sz = 16; sz < n; sz+=sz){
			for(int i = 0;i < n-sz; i+=sz+sz){
				// 优化点二：仅在 arr[mid]的值 大于 arr[mid+1]的值的时候, 把arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
				if(arr[i+sz-1].compareTo(arr[i+sz]) > 0){
					merge(arr, i, i+sz-1, Math.min(i+sz+sz-1, n-1));
				}
			}
		}
		
	}
	
	
	public static void main(String[] args){
		
		int N = 10000;
		
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
		SortTestHelper.testSort("sorting_Advance.MergeSortBU", arr);
		
		return;
	}
}
