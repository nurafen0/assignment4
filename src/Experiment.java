import java.util.Random;

public class Experiment {

    public void runTraversals(Graph g, String sizeLabel, int startVertex) {
        System.out.println("\n--- Testing " + sizeLabel + " Graph ---");

        long startBfs = System.nanoTime();
        g.bfs(startVertex);
        long endBfs = System.nanoTime();

        long startDfs = System.nanoTime();
        g.dfs(startVertex);
        long endDfs = System.nanoTime();

        long startDijkstra = System.nanoTime();
        g.dijkstra(startVertex);
        long endDijkstra = System.nanoTime();

        printResults(sizeLabel, (endBfs - startBfs), (endDfs - startDfs), (endDijkstra - startDijkstra));
    }

    public Graph createRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph(numVertices);
        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            int weight = rand.nextInt(10) + 1;
            g.addEdge(from, to, weight);
        }
        return g;
    }

    public void runMultipleTests() {
        Graph small = createRandomGraph(10, 15);
        runTraversals(small, "Small (10 v)", 0);

        Graph medium = createRandomGraph(30, 60);
        runTraversals(medium, "Medium (30 v)", 0);

        Graph large = createRandomGraph(100, 300);
        runTraversals(large, "Large (100 v)", 0);
    }

    public void printResults(String size, long bfsTime, long dfsTime, long dijkstraTime) {
        System.out.println("\nResults for " + size + ":");
        System.out.println("BFS Execution Time: " + bfsTime + " ns");
        System.out.println("DFS Execution Time: " + dfsTime + " ns");
        System.out.println("Dijkstra Execution Time: " + dijkstraTime + " ns");
        System.out.println("---------------------------------");
    }
}