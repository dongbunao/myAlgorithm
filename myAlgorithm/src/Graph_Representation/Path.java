package Graph_Representation;

import java.util.Stack;
import java.util.Vector;

public class Path {
	
	private Graph G;	// 图的引用
	private int s;	//起始点
	private boolean[] visited;	// 记录dfs过程中节点是否被遍历过
	private int[] from;	// 记录路径， from[i]表示查找的路径上i的上一个节点
	
	// 构造函数，寻路算法，寻找图graph从s点到其他点的路径
	public Path(Graph graph, int s){
		//算法初始化
		G = graph;
		assert s >= 0 && s < G.V();
		
		visited = new boolean[G.V()];
		from = new int[G.V()];
		
		for(int i=0; i<G.V(); i++){
			visited[i] = false;
			from[i] = -1;
		}
		this.s = s;
		
		//寻路算法
		dfs(s);
		
	}
	
	// 图的深度优先遍历
	public void dfs(int v){
		visited[v] = true;
		for(int i : G.adj(v)){
			if(!visited[i]){
				from[i] = v;
				dfs(i);
			}
		}
	}
	
	// 查询s点到w点是否有路径
	boolean hasPath(int w){
		assert w >= 0 && w <G.V();
		return visited[w];
	}
	
	// 查询s点到w点的鲁路径，保存在vec中
	Vector<Integer> path(int w){
		assert w >= 0 && w < G.V();
		Stack<Integer> s = new Stack<Integer>();
		
		// 通过from数组你想查找s到w的路径，存放在栈中
		int p = w;
		while(p != -1){
			s.push(p);
			p = from[p];
		}
		
		// 从栈中依次取元素，得到s到w的顺序路径
		Vector<Integer> res = new Vector<Integer>();
		while(!s.empty()){
			res.add(s.pop());
		}
		
		return res;
	}
	
	// 打印s点到w点的路径
	void showPath(int w){
		assert hasPath(w);
		
		Vector<Integer> vec = path(w);
		for(int i=0; i<vec.size(); i++){
			System.out.println(vec.elementAt(i));
			if(i == vec.size() -1)
				System.out.println();
			else
				System.out.println("->");
		}
	}
	
}
