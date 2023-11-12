public class EdgeWeightedDigraph extends EdgeWeightedGraph {

  public EdgeWeightedDigraph() {
    super();
  }

  public EdgeWeightedDigraph(String filename) {
    super(filename);
  }

  @Override

  public void addEdge(String v, String w, double weight) {
    Edge e = new Edge(v, w, weight);
    addToList(v, e);
    if(!vertices.contains(v)) {
      vertices.add(v);
      totalVertices++;
    }
    if(!vertices.contains(w)) {
      vertices.add(w);
      totalVertices++;
    }
    totalEdges += 2;
    totalEdges++;
  }
  
  public void Calc(String filename){
    double passoUm;
    String checkString;
    double pesoEmHidrogenio = 1.0;
    //double next;
    for (Edge e : getEdges()) {
      checkString = e.getW();
      if (e.getV() == "hidrogenio"){
        System.out.println("é hidrogenio");
        passoUm = e.getWeight();
        pesoEmHidrogenio = passoUm;
      }
      else{
        
        e.setWeight(pesoEmHidrogenio*e.getWeight());
      }
      if (e.getW() == checkString) {
        
      }
      
      e.setWeight(pesoEmHidrogenio*e.getWeight());
      
      System.out.printf("%s * %f = %s %n", e.getV(), pesoEmHidrogenio, e.getW());
      //carry = carry * next;// errado
      //System.out.println(e.getV());
    }
    //System.out.println(carry);
  }
  @Override
  public String toDot() {
    StringBuilder sb = new StringBuilder();
    sb.append("digraph {" + NEWLINE);
    sb.append("rankdir = LR;" + NEWLINE);
    sb.append("node [shape = circle];" + NEWLINE);
    for (Edge e : getEdges())
      sb.append(String.format("%s -> %s [label=\"%.3f\"]", e.getV(), e.getW(), e.getWeight()) + NEWLINE);
    sb.append("}" + NEWLINE);
    return sb.toString();
  }
}
