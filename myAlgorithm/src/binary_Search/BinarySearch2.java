package binary_Search;

/**
 * 
    * @ClassName: BinarySearch2  
    * @Description: TODO(采用递归的方式实现二分查找)  
    * @author dongxiao  
    * @date 2018年6月5日  
    *
 */
public class BinarySearch2 {
	
	private BinarySearch2(){}
	
	public static int find(Comparable[] arr, int l, int r, Comparable target){
		if (l>r){
			return -1;
		}
		
		int mid = l + (r-l)/2;
		
		if (arr[mid].compareTo(target) == 0){
			return mid;
		}else if(arr[mid].compareTo(target) > 0){
			return find(arr, l, mid-1, target);
		}else{
			return find(arr, mid+1, r, target);
		}
	}
	
	public static int find(Comparable[] arr, Comparable target){
		return find(arr, 0, arr.length-1, target);
	}
	
	public static void main(String[] args){
		int N = 1000;
		Integer[] arr = new Integer[N];
		for(int i=0; i<N; i++){
			arr[i] = new Integer(i);
		}
		
		for(int i=0; i<2*N; i++){
			int v = BinarySearch2.find(arr, new Integer(i));
			if (i<N){
				assert v==i;
			}else{
				assert v==-1;
			}
		}
		return;
	}

}
