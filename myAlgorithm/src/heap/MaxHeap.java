package heap;

/**
 * 
    * @ClassName: MaxHeap  
    * @Description: TODO 最大堆的定义
    * @author dongxiao  
    * @date 2018年4月3日  
    *
 */
public class MaxHeap<Item extends Comparable> {
	
	protected Item[] data;
	protected int count;
	protected int capacity;
	
	// 构造函数   构造一个空堆，可以容纳capacity个元素
	public MaxHeap(int capacity){
		data = (Item[]) new Comparable[capacity + 1];
		count = 0;
		this.capacity = capacity;
	}
	
	// 构造函数  传入一个数组构造最大堆，这种建堆的时间复杂度为O(n)
	public MaxHeap(Item arr[]){
		int n = arr.length;
		data = (Item[]) new Comparable[n+1];
		capacity = n;
		
		for(int i=0; i<n; i++){
			data[i] = arr[i];
		}
		count = n;
		
		for(int i=count/2; i>=1; i--){
			shiftDown(i);
		}
		
	}
	
	// 返回堆中元素个数
	public int size(){
		return count;
	}
	
	// 返回一个布尔值，表示堆是否为空
	public boolean isEmpty(){
		return count == 0;
	}
	
	//  获得    最大堆堆顶元素
	public Item getMax(){
		
		if(count>0){
			return data[1];
		}
		else{
			return null;
		}
	}
	
	
	// 向最大堆中插入一个新的元素
	public void insert(Item item){
		if(count + 1 < capacity){
			// 插入后元素数量不能大于堆容量capacity
			data[count+1] = item;
			count ++;
			
			shiftUp(count);
		}
	}
	
	// 向最大堆中插入一个元素，最大堆的调整过程
	private void shiftUp(int k) {
		// TODO Auto-generated method stub
		while(k>1 && data[k/2].compareTo(data[k])<0){
			swap(k, k/2);
			k /= 2;
		}
	}

	private void swap(int i, int j) {
		// TODO Auto-generated method stub
		Item t = data[i];
		data[i] = data[j];
		data[j] = t;
	}
	
	
	//  取出   最大堆堆顶的元素
	public Item extractMax(){
		assert count > 0 : "堆空了";
		Item ret = data[1];
		swap(1, count);
		count --;
		shiftDown(1);
		
		return ret;
	}
	
	// 堆顶元素下沉的过程
	private void shiftDown(int k) {
		// TODO Auto-generated method stub
		while(2*k <= count){
			int j = 2*k;
			// data[j] 是 data[2*k]  和 data[2*k+1] 中的最大值
			if(j+1 <= count && data[j+1].compareTo(data[j])>0){
				j++;
			}
			
			if(data[k].compareTo(data[j]) >= 0){
				break;
			}
			
			swap(k, j);
			k = j;
		}
	}

	// 测试最大堆
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaxHeap<Integer> maxHeap = new MaxHeap<Integer>(100);
		int N= 50; // 堆中元素个数
		int M = 100; //堆中元素取值范围[0,M)
		for(int i = 0; i < N; i++){
			maxHeap.insert(new Integer((int) (Math.random()*M)));
		}
		
		Integer[] arr = new Integer[N];
		// 依次取出最大堆堆顶的元素放到数组中，数组就是有序的
		for(int i=N-1; i>=0; i--){
			arr[i] = maxHeap.extractMax();
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		for(int i=0; i<N; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
		
//		for(int i=0; i<N; i++){
//			assert arr[i-1]<arr[i];
//		}
	}

}
