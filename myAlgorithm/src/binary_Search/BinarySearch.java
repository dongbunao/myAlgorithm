package binary_Search;

/**
 * 
    * @ClassName: BinarySearch  
    * @Description: TODO(非递归的二分查找法的实现)  
    * @author dongxiao  
    * @date 2018年5月21日  
    *
 */
public class BinarySearch {
	
	private BinarySearch(){}
	
	/*
	 * 在有序的数组arr中，查找target
	 */
	public static int find(Comparable[] arr, Comparable target){
		int l = 0, r = arr.length-1;
		while(l<=r){
			//int mid = (r-l)/2;
			int mid = l + (r-l)/2;
			if(arr[mid].compareTo(target)==0){
				return mid;
			}
			if(arr[mid].compareTo(target)>0){
				r = mid -1;
			}else{
				l = mid + 1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		
		int N = 1000;
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++){
			arr[i] = new Integer(i);
		}
		
		for(int i=0; i<2*N; i++){
			int v = BinarySearch.find(arr, new Integer(i));
			if(v <= N){
				assert v == i;
			}else{
				assert v == -1;
			}
		}
		return;
	}
}
