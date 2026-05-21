import java.util.*;

public class Graph {
    private final Map<Integer, List<Edge>> adjList;
    private final int numVertices;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        this.adjList = new HashMap<>();
        for (int i = 0; i < numVertices; i++) {
            adjList.put(i, new ArrayList<>());
        }
    }

    public void addEdge(int from, int to, int weight) {
        if (adjList.containsKey(from) && adjList.containsKey(to)) {
            adjList.get(from).add(new Edge(from, to, weight));
        }
    }

    public void bfs(int start) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");

            for (Edge edge : adjList.getOrDefault(vertex, new ArrayList<>())) {
                int neighbor = edge.getDestination();
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    public void dfs(int start) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(start, visited);
        System.out.println();
    }

    private void dfsRecursive(int current, Set<Integer> visited) {
        visited.add(current);
        System.out.print(current + " ");

        for (Edge edge : adjList.getOrDefault(current, new ArrayList<>())) {
            int neighbor = edge.getDestination();
            if (!visited.contains(neighbor)) {
                dfsRecursive(neighbor, visited);
            }
        }
    }

    public void dijkstra(int start) {
        int[] distances = new int[numVertices];
        boolean[] visited = new boolean[numVertices];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        for (int count = 0; count < numVertices - 1; count++) {
            int u = findMinDistance(distances, visited);
            if (u == -1) break;

            visited[u] = true;

            for (Edge edge : adjList.getOrDefault(u, new ArrayList<>())) {
                int v = edge.getDestination();
                int weight = edge.getWeight();

                if (!visited[v] && distances[u] != Integer.MAX_VALUE
                        && distances[u] + weight < distances[v]) {
                    distances[v] = distances[u] + weight;
                }
            }
        }
        printDijkstraResults(start, distances);
    }

    private int findMinDistance(int[] distances, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < numVertices; v++) {
            if (!visited[v] && distances[v] <= min) {
                min = distances[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printDijkstraResults(int start, int[] distances) {
        System.out.println("\n--- Dijkstra Results from Vertex " + start + " ---");
        for (int i = 0; i < distances.length; i++) {
            String distLabel = (distances[i] == Integer.MAX_VALUE) ? "INF" : String.valueOf(distances[i]);
            System.out.println("Distance to " + i + ": " + distLabel);
        }
    }
}