import java.util.HashMap;
import java.util.LinkedList;

import com.sun.javafx.collections.MappingChange.Map;

public class Graph {
	HashMap<Integer, GraphNode> nodes=new HashMap<Integer, GraphNode>();

	public Graph(int size) {
		for(int i=0;i<size;++i){
			nodes.put(i, new GraphNode(i));
		}
	}

	boolean addEdge(Graph g,int u,int v){
		if(g.nodes.containsKey(u) && g.nodes.containsKey(v)){
			g.nodes.get(u).adjList.add(g.nodes.get(v));
			return true;
		}
		return false;
	}
	public void bfs(Graph g,int src){
		LinkedList<GraphNode> graphNodes=new LinkedList<>();
		graphNodes.add(g.nodes.get(src));
		while(!graphNodes.isEmpty()){
			GraphNode graphNode=graphNodes.removeFirst();
			graphNodes.addAll(graphNode.adjList);
			if(!graphNode.visted){
				System.out.println(graphNode.u);
				graphNode.visted=true;
			}
		}
	}
	public void printAdjects(Graph graph){
		int i=0;
		for(GraphNode graphNode:graph.nodes.values()){
			
			if(!graphNode.adjList.isEmpty()){
				System.out.print(i+"-->");
			for(GraphNode graphNode2:graphNode.adjList)
			System.out.print(graphNode2.u+" ");
			System.out.println();
			}
			
			++i;
		}
	}
	public static void main(String[] args) {
		int V = 8;
		Graph graph = new Graph(V);
		/*graph.addEdge(graph, 0, 1);
		graph.addEdge(graph, 0, 4);
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 1, 4);
		graph.addEdge(graph, 2, 3);
		graph.addEdge(graph, 3, 4);*/
		graph.addEdge(graph, 1, 2);
		graph.addEdge(graph, 2, 1);
		graph.addEdge(graph, 1, 3);
		graph.addEdge(graph, 3, 1);
		graph.addEdge(graph, 5, 2);
		graph.addEdge(graph, 7, 3);
		graph.printAdjects(graph);
		//graph.bfs(graph, 0);
	}
}

class GraphNode{
	int u;
	LinkedList<GraphNode> adjList;
	boolean visted;
	public GraphNode(int u) {
		this.u=u;
		adjList=new LinkedList<GraphNode>();
		this.visted=false;
	}
}
