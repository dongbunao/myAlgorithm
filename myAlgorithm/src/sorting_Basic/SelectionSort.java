package sorting_Basic;

public class SelectionSort {
	
	private SelectionSort(){};	// 外部不能产生本类的实例  （反射呢？）
	
	private static void sort(int[] arr){
		int n = arr.length;
		for(int i = 0;i < n;i++){
			
			int minIndex = i;
			
			for(int j = i+1;j<n;j++){
				if(arr[j]<arr[minIndex])
					minIndex = j;
			}
			
			swap(arr,i,minIndex);
			
		}
	}
	
	public static void swap(int[] arr, int i, int j){
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}
	
	public static void main(String[] args){
		int[] arr = {3,4,8,2,6,9,1,10,7,5};
		SelectionSort.sort(arr);
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]);
			System.out.print(' ');
		}
		//System.out.println();
	}

}
