package com.mygraph

import zio._
import zio.Console._

object Main extends ZIOAppDefault {
  val graph = DirectedGraph(Map("A" -> Set("B", "C"), "B" -> Set("D"), "C" -> Set(), "D" -> Set()))

  override def run = {
    for {
      _ <- printLine("Graph Vertices: " + graph.vertices.mkString(", "))
      _ <- printLine("Graph Edges: " + graph.edges.mkString(", "))
      _ <- printLine("DFS from A: " + dfs(graph, "A").mkString(", "))
      _ <- printLine("BFS from A: " + bfs(graph, "A").mkString(", "))
    } yield ()
  }

  def dfs[V](graph: Graph[V, Edge[V]], start: V): Set[V] = {
    def dfsVisit(node: V, visited: Set[V]): Set[V] = {
      if (visited.contains(node)) visited
      else {
        val newVisited = visited + node
        graph.neighbors(node).foldLeft(newVisited)((v, n) => dfsVisit(n, v))
      }
    }
    dfsVisit(start, Set())
  }

  def bfs[V](graph: Graph[V, Edge[V]], start: V): Set[V] = {
    @scala.annotation.tailrec
    def bfsVisit(queue: List[V], visited: Set[V]): Set[V] = queue match {
      case Nil => visited
      case h :: t =>
        if (visited.contains(h)) bfsVisit(t, visited)
        else {
          val newVisited = visited + h
          bfsVisit(t ++ graph.neighbors(h).filterNot(visited.contains), newVisited)
        }
    }
    bfsVisit(List(start), Set())
  }
}
