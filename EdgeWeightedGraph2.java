import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EdgeWeightedGraph2 {
  protected static final String NEWLINE = System.getProperty("line.separator");

  protected Map<String, List<Edge>> graph;

  public EdgeWeightedGraph() {
    graph = new HashMap<>();
  }

  public EdgeWeightedGraph(String filename) {
    this();
    In in = new In(filename);
    String line;
    //String Input;
    //String Output;
    while((line = in.readLine()) != null) {
      String[] inputOutput = line.split("->");
      //System.out.println("1Split");
      String[] input = inputOutput[0].split(" ");
      //System.out.println("2Split");
      String[] output = inputOutput[1].split(" ");
      //System.out.println("3Split");
      //String[] edge = line.split(" ");
      for (int i = 0; i < input.length;  i=i+2) {
      addEdge(input[i+1], output[2], Integer.parseInt(input[i]));
      //System.out.println("F");
      }
      
    }
    in.close();
  }

  public void addEdge(String v, String w, int weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    addToList(w, e);
  }

  public Iterable<Edge> getAdj(String v) {
    return graph.get(v);
  }

  public Set<String> getVerts() {
    return graph.keySet();
  }

  public String toDot() {
    // Usa um conjunto de arestas para evitar duplicatas
    Set<String> edges = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    sb.append("graph {"+NEWLINE);
    sb.append("rankdir = LR;"+NEWLINE);
    sb.append("node [shape = circle];"+NEWLINE);
    for(String v: getVerts().stream().sorted().toList()) {
      for (Edge e: getAdj(v)) {
        String edge = e.toString();
        if(!edges.contains(edge)) {
          sb.append(String.format("%s -- %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
          edges.add(edge);
        }
      }
    }
    sb.append("}" + NEWLINE);
    return sb.toString();
  }

  // Adiciona um vértice adjacente a outro, criando a lista
  // de adjacências caso ainda não exista no dicionário
  protected List<Edge> addToList(String v, Edge e) {
    List<Edge> list = graph.get(v);
    if (list == null)
      list = new LinkedList<>();
    list.add(e);
    graph.put(v, list);
    return list;
  }
}
