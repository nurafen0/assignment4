Assignment 4: Graph Traversal and Representation System
A. Project Overview
This project implements a graph data structure using an Adjacency List. 
The system supports:
Vertices and Edges: Representing nodes and their connections.
BFS (Breadth-First Search): Exploring the graph level by level.
DFS (Depth-First Search): Exploring as far as possible along each branch before backtracking.
The goal is to compare the performance of these algorithms across different graph sizes (10, 30, and 100 vertices).

B. Class Descriptions
Vertex: A simple class representing a node with a unique id.
Edge: Represents a directed connection between a source and a destination vertex.
Graph: The core data structure. It uses a HashMap<Integer, List<Integer>> for the adjacency list to store connections efficiently.
Experiment: A utility class that automates graph creation, executes traversals, and measures execution time in nanoseconds.

C. Algorithm Descriptions
Breadth-First Search (BFS)
Logic: Uses a Queue (FIFO). It starts at a source node, visits all its neighbors, then moves to the neighbors' neighbors.
Use Case: Finding the shortest path in unweighted graphs.Complexity: O(V + E)

Depth-First Search (DFS)
Logic: Uses Recursion (Stack-based). It dives deep into one branch until it hits a dead end, then backtracks.
Use Case: Topological sorting, cycle detection, and solving puzzles (like mazes).
Complexity: O(V + E).

D. Experimental Results
Execution Time Comparison
Graph Size,          BFS (ns),         DFS (ns)
Small (10 v),        "2,369,900",      "198,800"
Medium (30 v),       "375,700",        "418,000"
Large (100 v),       "1,727,100",      "1,588,700"

Observations
Graph Size Effect: As the number of vertices increases, the execution time grows. However, for 100 nodes, the time is still very low  showing that O(V+E) is highly efficient.
BFS vs DFS: In my experiments, DFS was often slightly faster on smaller graphs, likely due to the overhead of Queue operations in BFS compared to simple recursion in DFS.
JVM Warm-up: The first test sometimes shows a higher time than the Medium test. This is due to the JVM "warming up" and compiling the code during the first execution.

F. Reflection
Through this assignment, I learned how to represent complex relationships using adjacency lists and how different traversal strategies behave. BFS is intuitive for finding "proximity," while DFS is powerful for exhaustive searching.
The biggest challenge was managing the execution time measurements. I realized that the first run is often slower because of Java's JIT compilation, so consistent testing is key to getting accurate data.







