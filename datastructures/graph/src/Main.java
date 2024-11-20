//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
      public static void main(String[] args) {

            Graph myGraph = new Graph();

            myGraph.addVertex("A");
            myGraph.addVertex("B");
            myGraph.addVertex("C");
            myGraph.addVertex("D");

            myGraph.addEdge("A", "B");
            myGraph.addEdge("A", "C");
            myGraph.addEdge("A", "D");
            myGraph.addEdge("B", "D");
            myGraph.addEdge("C", "D");

            myGraph.removeVertext("D");

            //myGraph.removeEdge("A", "B");

            myGraph.printGraph();
      }
}