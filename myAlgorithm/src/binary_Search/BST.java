package binary_Search;

public class BST<Key extends Comparable<Key>, Value> {
	// 二分搜索树
	// 由于Key需要进行比较，所以key extends Comparable<Key>
	
	//内部类定义 节点
	private class Node{
		private Key key;
		private Value value;
		private Node left, right;
		public Node(Key key, Value value){
			this.key = key;
			this.value = value;
			left = right = null;
		}
	}
	
	private Node root;	//根节点
	private int count;	//树中的节点个数
	
	//构造函数， 默认构造一个空的二叉搜索树
	private BST(){
		root = null;
		count = 0;
	}
	
	//树的节点个数
	public int size(){
		return count;
	}
	
	// 树是否为空
	public boolean isEmpty(){
		return count == 0;
	}
	
	public static void mian(String[] args){
		
	}

}
