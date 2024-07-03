package com.mygraph

object TopologicalSort {

  def sort[V](graph: DirectedGraph[V]): List[V] = {
    val visited = collection.mutable.Set[V]()
    val result = collection.mutable.ListBuffer[V]()

    def dfs(vertex: V): Unit = {
      visited.add(vertex)
      graph.neighbors(vertex).foreach { neighbor =>
        if (!visited.contains(neighbor)) {
          dfs(neighbor)
        }
      }
      result.prepend(vertex)
    }

    graph.vertices.foreach { vertex =>
      if (!visited.contains(vertex)) {
        dfs(vertex)
      }
    }

    result.toList
  }
}
