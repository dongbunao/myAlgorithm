package test;

import java.util.Arrays;

import utils.SortTestHelper;

public class Main {

	public static void main(String[] args) {
		
		int N =10000;
		
		//一般的测试
		System.out.println("----------对于随机的普通数组测试----------");
		Integer[] arr1 = SortTestHelper.generateRandomArray(N, 0, N);
		Integer[] arr2 = Arrays.copyOf(arr1, N);
		Integer[] arr3 = Arrays.copyOf(arr1, N);
		Integer[] arr4 = Arrays.copyOf(arr1, N);
		Integer[] arr5 = Arrays.copyOf(arr1, N);
		Integer[] arr6 = Arrays.copyOf(arr1, N);
		
		System.out.println("选择排序：");
		SortTestHelper.testSort("sorting_Basic.SelectionSort", arr1);
		System.out.println("插入排序排序：");
		SortTestHelper.testSort("sorting_Basic.InsertionSort", arr2);
		System.out.println("归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSort", arr3);
		System.out.println("自底向上归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSortBU", arr4);
		System.out.println("基础快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort", arr5);
		System.out.println("双路快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort2Ways", arr6);
		
		// 测试近乎有序的数组
		System.out.println("----------对于近乎有序的数组测试----------");
		int swapTimes = 10;
		arr1 = SortTestHelper.generateNearlyOrderedArray(N, swapTimes);
		arr2 = Arrays.copyOf(arr1, N);
		arr3 = Arrays.copyOf(arr1, N);
		arr4 = Arrays.copyOf(arr1, N);
		arr5 = Arrays.copyOf(arr1, N);
		arr6 = Arrays.copyOf(arr1, N);
		
		System.out.println("选择排序：");
		SortTestHelper.testSort("sorting_Basic.SelectionSort", arr1);
		System.out.println("插入排序排序：");
		SortTestHelper.testSort("sorting_Basic.InsertionSort", arr2);
		System.out.println("归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSort", arr3);
		System.out.println("自底向上归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSortBU", arr4);
		System.out.println("基础快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort", arr5);
		System.out.println("双路快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort2Ways", arr6);
		
		// 测试近乎有序的数组
		System.out.println("----------对于含有大量重复元素的数组测试----------");
		
		arr1 = SortTestHelper.generateRandomArray(N, 0, 20);
		arr2 = Arrays.copyOf(arr1, N);
		arr3 = Arrays.copyOf(arr1, N);
		arr4 = Arrays.copyOf(arr1, N);
		arr5 = Arrays.copyOf(arr1, N);
		arr6 = Arrays.copyOf(arr1, N);
		
		System.out.println("选择排序：");
		SortTestHelper.testSort("sorting_Basic.SelectionSort", arr1);
		System.out.println("插入排序排序：");
		SortTestHelper.testSort("sorting_Basic.InsertionSort", arr2);
		System.out.println("归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSort", arr3);
		System.out.println("自底向上归并排序：");
		SortTestHelper.testSort("sorting_Advance.MergeSortBU", arr4);
		System.out.println("基础快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort", arr5);
		System.out.println("双路快速排序：");
		SortTestHelper.testSort("sorting_Advance.QuickSort2Ways", arr6);
		
		return;

	}

}
