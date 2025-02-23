# Functional Programming with Scala

This project showcases functional programming concepts using Scala, focusing on graph algorithms and asynchronous effect management with ZIO. The main components of the project include various graph algorithms like Depth-First Search (DFS), Breadth-First Search (BFS), Dijkstra's algorithm for shortest paths, and the Floyd-Warshall algorithm for finding all pairs shortest paths. It also includes implementations of directed and weighted graphs.

## Requirements

- **Java 17**: Required to run the project.
- **Scala 3**: Programming language used for the project.
- **sbt (Scala Build Tool)**: Build tool for Scala projects.
- **ZIO Library**: Provides functional programming constructs for managing asynchronous effects and error handling.

## Project Overview

The project consists of several key components:

### Graph Representations

- **DirectedGraph**: Represents directed graphs, where edges have a direction.
- **WeightedGraph**: Represents graphs with edges that have weights, supporting operations like adding and removing edges.

### Graph Algorithms

- **Depth-First Search (DFS)**: Traverses the graph by exploring as far as possible along each branch before backtracking.
- **Breadth-First Search (BFS)**: Traverses the graph level by level, exploring all nodes at the present depth level before moving on to nodes at the next depth level.
- **Dijkstra's Algorithm**: Computes the shortest path from a single source node to all other nodes in a weighted graph with non-negative weights.
- **Floyd-Warshall Algorithm**: Computes shortest paths between all pairs of nodes in a weighted graph, allowing for negative weights but no negative weight cycles.

### ZIO Integration

- **ZIO**: Used for managing asynchronous effects and error handling. It provides a powerful way to handle operations that may fail or require concurrency, using a functional approach.

### GraphViz Integration

- **GraphViz**: A tool to generate visual representations of graphs. The project includes functionality to convert graph data into a GraphViz-compatible format, allowing for visual inspection of the graph's structure.

## Instructions

### Build and Run

1. **Clone the Repository**

   To get a local copy of the project, use the following command:
   ```
   git clone https://github.com/yourusername/functional-programming-scala.git

   ```



2. **Compile the project:**
```
sbt compile
```


3. **Run the application:**

```
sbt run
```


### Usage Examples

The main application (`Main.scala`) demonstrates various operations on graphs:

- Printing graph vertices and edges.
- Performing DFS and BFS traversal from a starting vertex.
- Computing shortest paths using Dijkstra's algorithm.
- Computing all pairs shortest paths using Floyd-Warshall algorithm.
- Generating GraphViz representations of graphs.

### Design Decisions

- **Graph Representation**: Used Scala's immutable maps and sets for representing graphs and their edges, ensuring thread safety and functional purity.

- **Algorithm Implementations**: Each algorithm (DFS, BFS, Dijkstra, Floyd-Warshall) is implemented as pure functions, emphasizing functional programming principles and immutability.

- **Error Handling**: ZIO is used for managing asynchronous effects and functional error handling, ensuring robustness in concurrent environments.

- **State Management**: Graph state is managed using immutable data structures, maintaining consistency and eliminating side effects.

- **Logging**: Simple console logging (`printLine`) is used for outputting results and graph representations.

### Testing

1. **Run tests:**
```
sbt test
```

2. **Test Coverage:**
The project aims for comprehensive test coverage, ensuring correctness of graph algorithms and ZIO effects handling.