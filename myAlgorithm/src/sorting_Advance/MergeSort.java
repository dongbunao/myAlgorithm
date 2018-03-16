package sorting_Advance;

import java.util.Arrays;

import utils.SortTestHelper;

public class MergeSort {
	
	private MergeSort(){};
	
	// 把arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
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

	
	//递归调用归并排序，对arr[1...r]的范围进行排序
	private static void sort(Comparable[] arr, int l, int r) {
		// TODO Auto-generated method stub
		if(l >= r){	//如果左下表大于右下标，不用再进行归并
			return;
		}
		
		int mid = (l + r)/2;	//mid 为数组的中间元素位置
		sort(arr, l, mid);	//递归左半部分
		sort(arr, mid+1, r);  //递归右半部分
		
		//把arr[l...mid] 和 arr[mid+1...r] 两部分进行归并
		merge(arr, l, mid, r);
	}
	
	//参数 Comparable[] arr  供反射使用
	public static void sort(Comparable[] arr){
		int n = arr.length;
		sort(arr, 0, n-1);
	}
	

	public static void main(String[] args){
		
		int N = 1000000;  //百万数据量，O(n^2)的算法不要轻易尝试百万数据量。
		Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 1000000);
		SortTestHelper.testSort("sorting_Advance.MergeSort", arr);
		
		return;
	}

}
