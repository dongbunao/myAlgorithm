package Graph_Representation;

// 图的接口定义
public interface Graph {
	
	public int V();
	public int E();
	public void addEdge();
	public void hasEdge();
	void show();
	public Iterable<Integer> adj(int v);

}
