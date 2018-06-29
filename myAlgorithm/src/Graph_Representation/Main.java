package Graph_Representation;

//测试寻路算法
public class Main {
	public static void main(String[] args){
		String filename = "./src/Graph_Representation/testG.txt";
		SparseGraph g = new SparseGraph(7, false);
		ReadGraph readGraph = new ReadGraph(g, filename);
		g.show();
		System.out.println();
		
		Path path = new Path(g,0);
		System.out.println("path from 0 to 6:");
		path.showPath(6);
	}
	
}
