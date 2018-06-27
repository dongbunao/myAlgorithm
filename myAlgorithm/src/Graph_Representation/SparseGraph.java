package Graph_Representation;

import java.util.Vector;

// 稀疏图 邻接表
public class SparseGraph {
	
	private int n;	//图中节点数量
	private int m;	//图中边的数量
	private boolean directed;	//是否为有向图
	private Vector<Integer>[] g;	//图中具体数据
	
	// 构造函数
	public SparseGraph(int n, boolean directed){
		assert n > 0;
		this.n = n;
		this.m = 0;
		this.directed = directed;
		g = (Vector<Integer>[])new Vector[n];
		for(int i=0; i<n; i++){
			g[i] = new Vector<Integer>();
		}
	}
	
	public int v(){
		return n;
	}
	
	public int E(){
		return m;
	}
	
	// 向图中添加一条边
	public void addEdge(int v, int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		g[v].add(w);
		if(v != w && !directed){
			g[w].add(v);
		}
		
		m++;
	}
	
	// 验证图中是否有v到w的边
	public boolean hasEdge(int v, int w){
		assert v >= 0 && v < n;
		assert w >= 0 && w < n;
		
		for(int i=0; i<g[v].size(); i++){
			if(g[v].elementAt(i) == w)
				return true;
		}
		
		return false;
	}
	
	
}
