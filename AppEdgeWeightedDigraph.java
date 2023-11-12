public class AppEdgeWeightedDigraph
{
  public static void main(String[] args) {
    /* 
    Graph g = new Graph();
    g.addEdge("0", "1");
    g.addEdge("0", "2");
    g.addEdge("2", "1");
    */
    //EdgeWeightedDigraph g = new EdgeWeightedDigraph("casoa5.txt");
    EdgeWeightedDigraph h = new EdgeWeightedDigraph("tinyEWD.txt");

    /*
    for (String v : h.getVerts()) {
      System.out.print(v + ": ");
      for (Edge e : h.getAdj(v))
        System.out.print(e + " ");
      System.out.println();
    }*/

    //System.out.println();
    System.out.println(h.toDot());

    //g.Calc("casoa5.txt");
    //h.Calc("tinyEWD.txt");
  }
}
