package binary_Search;

import java.util.LinkedList;
import java.util.Queue;

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
		
		public Node(Node node) {
			this.key = node.key;
			this.value = node.value;
			this.left = node.left;
			this.right = node.right;
		}
	}
	
	private Node root;	//根节点
	private int count;	//树中的节点个数
	
	//构造函数， 默认构造一个空的二叉搜索树
	public BST(){
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
	
	// 向二叉树中插入一个新的（key，value）数据对
	public void insert(Key key, Value value){
		root = insert(root, key, value);
	}
	
	// 判断二分搜索树中是否存在键key
	public boolean contain(Key key){
		return contain(root, key);
	}
	
	// 在二分搜索书中查找键key对应的value，如果这个值不存在返回null
	public Value search(Key key){
		return search(root, key);
	}
	
	// 二分搜索树的前序遍历
	public void preOrder(){
		preOrder(root);
	}
	
	// 二分搜索树的中序遍历
	public void inOrder(){
		inOrder(root);
	}
	
	// 二分搜索树的后序遍历
	public void postOrder(){
		postOrder(root);
	}
	
	//二分搜索树的广度优先遍历（层序遍历）
	public void levelOrder(){
		//使用LinkedList作为队列使用
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		while(!q.isEmpty()){
			Node node = q.remove();
			System.out.println(node.key);
			
			if(node.left != null){
				q.add(node.left);
			}
			if(node.right != null){
				q.add(node.right);
			}
		}
	}
	

	// 返回以node为根的二分搜索树的最小值所在的节点
	public Key minimum(){
		assert count != 0;
		Node minNode = mininum(root);
		return minNode.key;
	}
	
	// 返回以node为根的二分搜索树的最大值所在的节点
	public Key maxnum(){
		assert count != 0;
		Node node = maxnum(root);
		return node.key;
	}
	
	// 删除以node为根的二分搜索树中最小节点
	public void removeMin(){
		if(root != null){
			root = removeMin(root);
		}
	}
	
	// 删除以node为根的二分搜索树中最大节点
	public void removeMax(){
		if(root != null){
			root = removeMax(root);
		}
	}
	
	//_________________________________________________________________________________________________
	
	private Node insert(Node node, Key key, Value value){
		if (node == null){	//树空的情况下，直接插入
			count++;
			return new Node(key, value);
		}
		
		if(key.compareTo(node.key)==0){	//键和当前节点键相同，覆盖当前节点的值
			node.value = value;
		}else if(key.compareTo(node.key)<0){	//键小于当前节点键，递归左子树
			node.left = insert(node.left, key, value);
		}else{	//键小于当前节点键，递归右子树
			node.right = insert(node.right, key, value);
		}
		
		return node;
	}
	
	//判断二分搜索树中是否存在键key
	private boolean contain(Node node, Key key){
		if(node == null){
			return false;
		}
		
		if(node.key.compareTo(key)==0){
			return true;
		}else if(key.compareTo(node.key)>0){
			return contain(node.right, key);
		}else{
			return contain(node.left, key);
		}
		
	}
	
	// 在二分搜索书中查找键key对应的value，如果这个值不存在返回null
	private Value search(Node node, Key key){
		if(node == null){
			return null;
		}
		
		if (key.compareTo(node.key)==0){
			return node.value;
		}else if(key.compareTo(node.key)>0){
			return search(node.right, key);
		}else{
			return search(node.left, key);
		}
		
	}
	
	//二分搜索树的前序遍历
	private void preOrder(Node node){
		if(node != null){
			System.out.println(node.key);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	//二分搜索树的中序遍历
	private void inOrder(Node node){
		if(node != null){
			inOrder(node.left);
			System.out.println(node.key);
			inOrder(node.right);
		}
	}
	
	//二分搜索树的后序遍历
	private void postOrder(Node node){
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			System.out.println(node.key);
		}
	}
	
	// 返回以node为根的二分搜索树的最小值所在的节点
	private Node mininum(Node node){
		if(node.left == null){
			return node;
		}
		return mininum(node.left);
	}
	
	
	// 返回以node为根的二分搜索树的最大值所在的节点
	private Node maxnum(Node node){
		if(node.right == null){
			return node;
		}
		return maxnum(node.right);
	}
	
	// 删除以node为根的二分搜索树中最小节点，返回删除最小节点后的二分搜索树的根
	private Node removeMin(Node node){
		if(node.left == null){
			Node rightNode = node.right; //右子树为空也同样适用
			node.right =null;
			count --;
			return rightNode;
		}
		
		node.left = removeMin(node.left);
		
		return node;//?
	}
	
	// 删除以node为根的二分搜索树中最大小节点，返回删除最大节点后的二分搜索树的根
	private Node removeMax(Node node){
		if(node.right == null){
			Node leftNode = node.left;
			node.left = null;
			count --;
			return leftNode;
		}
		
		node.right = removeMax(node.right);
		return node;  //?
	}
	
	// 删除二分搜索树中键值为key的节点， 返回删除节点之后的二分搜索树的根
	// 先找到键值为key的节点
	private Node remove(Node node, Key key){
		if(node == null){ // 树为空或者是节点不存在的看情况？
			return null;
		}
		
		if(key.compareTo(node.key) < 0){
			node.left = remove(node.left, key);
			return node;
		}else if(key.compareTo(node.key) > 0){
			node.right = remove(node.right, key);
			return node;
		}else{	//待删除的节点就是当前节点
			// 左子树为空的情况
			if(node.left == null){
				Node rightNode = node.right;
				node.right = null;
				count --;
				return rightNode;
			}
			
			// 右子树为空的情况
			if(node.right == null){
				Node leftNode = node.left;
				node.right = null;
				count --;
				return leftNode;
			}
			
			// 左右子树都不为空的情况
			// 用 待删除节点的前驱或者后继节点顶替待删除节点位置   （Hubbard deletion）
			Node successor = new Node(mininum(node.right));	//找到前驱节点，复制一份
			count ++;
			
			successor.left = node.left;
			successor.right = removeMin(node.right);
			
			node.left = node.right = null;
			count --;
			
			return successor;
			
		}
		
		
	}
	
	public static void mian(String[] args){
		
		
	}

}
