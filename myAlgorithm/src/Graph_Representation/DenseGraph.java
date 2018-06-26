package Graph_Representation;

// 稠密图  邻接矩阵
public class DenseGraph {
	 private int n;	// 节点数
	 private int m;	// 边数
	 private boolean directed;	// 是否为有向图
	 private boolean[][] g; //图的具体数据
	 
	 // 构造函数
	 public DenseGraph(int n, boolean directed){
		 assert n >= 0;
		 this.n = n;
		 this.m = 0;
		 this.directed = directed;
		 // g初始化为n*n的布尔矩阵， 每一个g[i][j]均为false， 表示没有边相连
		 // boolean类型的值默认false
		 g = new boolean[n][n];
	 }
	 
	 public int V(){
		 return n;
	 }
	 
	 public int E(){
		 return m;
	 }
	 
	 // 向图中添加一个边
	 public void addEdge(int v, int w){
		 assert v >= 0 && v < n;
		 assert w >= 0 && w < n;
		 
		 if(hasEdge(v, w))
			 return;
		 g[v][w] = true;
		 if(!directed)
			 g[w][v] = true;
		 
		 m++;
	 }
	 
	 // 验证图中两个点是否有边
	 public boolean hasEdge(int v, int w){
		 assert v >= 0 && v < n;
		 assert w >= 0 && w < n;
		 return g[v][w];
	 }
}
