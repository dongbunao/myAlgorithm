package sorting_Advance;

import java.util.Arrays;

import sorting_Basic.InsertionSort;
import utils.SortTestHelper;

public class MergeSort {
	
	private MergeSort(){};
	
	/*
	 * 把arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
	 */
	private static void merge(Comparable[] arr, int l, int mid, int r) {
		
		// Arrays.copyOfRange(T[ ] original,int from,int to)将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
		// 注意这里包括下标from，不包括下标to。
		// 这个方法在一些处理数组的编程题里很好用，效率和clone基本一致，都是native method，比利用循环复制数组效率要高得多。
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

	
	/*
	 * 递归调用归并排序，对arr[1...r]的范围进行排序
	 */
	private static void sort(Comparable[] arr, int l, int r) {
		
//		// 循环终止条件
//		if(l >= r){	//其实是 if(l = r) 左下标 大于 右下标的事情不可能发生
//			return;
//		}
		
		// 优化一：对于小规模数组使用插入排序
		if(l - r <= 15){
			InsertionSort.sort(arr, l, r);
			return;
		}
		
		
		int mid = (l + r)/2;	//mid 为数组的中间元素位置
		sort(arr, l, mid);	//递归左半部分
		sort(arr, mid+1, r);  //递归右半部分
		
		//优化二：仅在 arr[mid]的值 大于 arr[mid+1]的值的时候, 把arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
		if(arr[mid].compareTo(arr[mid+1]) > 0){
			merge(arr, l, mid, r);
		}
		
	}
	
	/*
	 * 参数 Comparable[] arr  供反射使用
	 */
	public static void sort(Comparable[] arr){
		int n = arr.length;
		sort(arr, 0, n-1);
	}
	

	public static void main(String[] args){
		
		int N = 10000;  //百万数据量，O(n^2)的算法不要轻易尝试百万数据量。
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 10000);
		
//		for(int i=0; i<arr.length; i++){
//			System.out.print(arr[i]+" ");
//		}
//		System.out.println();
		SortTestHelper.testSort("sorting_Advance.MergeSort", arr);
		
		return;
	}

}
