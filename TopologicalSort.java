import java.util.*;

public class TopologicalSort {
    private Stack<Integer> stack;
    
    public TopologicalSort(g){
        
    }
    
    public void topologicalSortUtil(Digraph graph, String v, boolean[] visited) {
        visited[v] = true;
        for (Integer neighbor : graph.getVerts()) {
            if (!visited[neighbor]) {
                topologicalSortUtil(graph, neighbor, visited);
            }
        }
        stack.push(v);
    }
    
    public void topologicalSort(Graph g) {
        //int numVertices = graph.getNumVertices();
        boolean[] visited = new boolean[numVertices];
        
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                topologicalSortUtil(g, i, visited);
            }
        }
        
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
    
    public static void main(String[] args) {
        Digraph graph = new Digraph("tinyag.txt");
        
        
        TopologicalSort ts = new TopologicalSort();
        System.out.println("Topological Sort: ");
        ts.topologicalSort(graph);
    }
}
