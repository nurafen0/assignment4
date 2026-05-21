Assignment 4: Graph Traversal and Representation System (Including Dijkstra Bonus)

A. Project Overview
This project implements a graph data structure using an Adjacency List. The system was extended to support weighted edges and the calculation of shortest paths.
The system supports:

Vertices and Edges: Representing nodes and weighted connections.

BFS (Breadth-First Search): Exploring the graph level by level.

DFS (Depth-First Search): Exploring branches deeply using recursion.

Dijkstra’s Algorithm: Finding the shortest path from a source node to all other nodes in a weighted graph.


B. Class Descriptions

Vertex: A class representing a node with a unique ID.

Edge: Represents a directed connection containing a source, destination, and weight.

Graph: The core data structure using a HashMap<Integer, List<Edge>>. It contains the logic for BFS, DFS, and Dijkstra’s algorithm.

Experiment: A utility class that automates the creation of random weighted graphs and measures the execution time of all three algorithms.

C. Algorithm Descriptions
Breadth-First Search (BFS): Uses a Queue (FIFO) to find proximity in $O(V + E)$.
Depth-First Search (DFS): Uses Recursion (Stack-based) for exhaustive searching in $O(V + E)$. 
Dijkstra’s Algorithm: A greedy algorithm that finds the shortest path in a weighted graph. This implementation uses simple loops to find the minimum distance node, resulting in a complexity of $O(V^2)$.

E. ObservationsDijkstra Performance: Dijkstra’s algorithm takes significantly longer than BFS and DFS on large graphs. This is expected because the $O(V^2)$ implementation performs a full scan of the distance array for every vertex processed.
Scalability: While BFS and DFS remain nearly linear, Dijkstra’s execution time jumps from 0.7ms (Medium) to 362ms (Large), demonstrating the quadratic growth of the simple loop implementation.
Path Accuracy: The algorithm correctly identified unreachable nodes (marked as INF) and calculated the precise cumulative weight for reachable paths.


F. Reflection
This assignment demonstrated how to transition from simple unweighted traversals to weighted pathfinding. 
Implementing Dijkstra without a Priority Queue helped me understand the raw "greedy" logic of the algorithm—always picking the closest unvisited node and "relaxing" its neighbors. 
The biggest takeaway was seeing how a higher time complexity ($O(V^2)$ vs $O(V+E)$) impacts performance as the dataset grows.



