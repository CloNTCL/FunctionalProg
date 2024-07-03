package com.mygraph

case class WeightedEdge[V](from: V, to: V, weight: Double)
case class WeightedGraph[V](adjList: Map[V, Set[(V, Double)]]) extends Graph[V, WeightedEdge[V]] {
  def vertices: Set[V] = adjList.keySet
  def edges: Set[WeightedEdge[V]] = adjList.flatMap { case (v, neighbors) => neighbors.map(n => WeightedEdge(v, n._1, n._2)) }.toSet
  def neighbors(vertex: V): Set[V] = adjList.getOrElse(vertex, Set()).map(_._1)
  def addEdge(edge: WeightedEdge[V]): WeightedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) + (edge.to -> edge.weight)))
    WeightedGraph(updatedAdjList)
  }
  def removeEdge(edge: WeightedEdge[V]): WeightedGraph[V] = {
    val updatedAdjList = adjList + (edge.from -> (adjList.getOrElse(edge.from, Set()) - (edge.to -> edge.weight)))
    WeightedGraph(updatedAdjList)
  }
}
