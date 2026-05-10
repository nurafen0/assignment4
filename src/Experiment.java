import java.util.Random;

public class Experiment {

    // Runs both BFS and DFS on a given graph and prints the time taken
    public void runTraversals(Graph g, String sizeLabel, int startVertex) {
        System.out.println("\n--- Testing " + sizeLabel + " Graph ---");

        // Measure BFS
        long startBfs = System.nanoTime();
        g.bfs(startVertex);
        long endBfs = System.nanoTime();

        // Measure DFS
        long startDfs = System.nanoTime();
        g.dfs(startVertex);
        long endDfs = System.nanoTime();

        printResults(sizeLabel, (endBfs - startBfs), (endDfs - startDfs));
    }

    // Helper to generate a graph with random edges
    public Graph createRandomGraph(int numVertices, int numEdges) {
        Graph g = new Graph();
        for (int i = 0; i < numVertices; i++) {
            g.addVertex(new Vertex(i));
        }

        Random rand = new Random();
        for (int i = 0; i < numEdges; i++) {
            int from = rand.nextInt(numVertices);
            int to = rand.nextInt(numVertices);
            g.addEdge(from, to);
        }
        return g;
    }

    public void runMultipleTests() {
        // 1. Small Graph (10 vertices)
        Graph small = createRandomGraph(10, 15);
        runTraversals(small, "Small (10 v)", 0);

        // 2. Medium Graph (30 vertices)
        Graph medium = createRandomGraph(30, 60);
        runTraversals(medium, "Medium (30 v)", 0);

        // 3. Large Graph (100 vertices)
        Graph large = createRandomGraph(100, 300);
        runTraversals(large, "Large (100 v)", 0);
    }

    public void printResults(String size, long bfsTime, long dfsTime) {
        System.out.println("\nResults for " + size + ":");
        System.out.println("BFS Execution Time: " + bfsTime + " ns");
        System.out.println("DFS Execution Time: " + dfsTime + " ns");
        System.out.println("---------------------------------");
    }
}