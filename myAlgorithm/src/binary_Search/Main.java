package binary_Search;

// 测试二分搜索树的前中后序遍历和层序遍历
public class Main {
	public static void main(String[] args){
		BST<Integer, Integer> bst = new BST<Integer, Integer>();
		
		//
		int N = 10;
		int M = 100;
		for(int i=0; i<N; i++){
			Integer key = new Integer((int) (Math.random()*M));
			// 为了后续测试方便，把key和value设置成一样的值
			bst.insert(key, key);
			System.out.print(key + " ");
		}
		System.out.println();

		// 测试二分搜索树的size
		System.out.println("size: " + bst.size());
		System.out.println();

		// 测试二分搜索树的前序遍历
		System.out.println("preOrder:");
		bst.preOrder();
		System.out.println();

		// 测试二分搜索树的中序遍历
		System.out.println("inOrder:");
		bst.inOrder();
		System.out.println();

		// 测试二分搜索树的后序遍历
		System.out.println("postOrder:");
		bst.postOrder();
		System.out.println();
		
		// 测试二分搜索树的层序遍历
		System.out.println("levelOrder:");
		bst.levelOrder();
		System.out.println();
		
	}
		
}
