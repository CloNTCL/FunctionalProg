package com.mygraph

import zio.json._

object GraphJson {
  implicit val edgeEncoder: JsonEncoder[Edge[String]] = DeriveJsonEncoder.gen[Edge[String]]
  implicit val edgeDecoder: JsonDecoder[Edge[String]] = DeriveJsonDecoder.gen[Edge[String]]

  implicit val graphEncoder: JsonEncoder[DirectedGraph[String]] = DeriveJsonEncoder.gen[DirectedGraph[String]]
  implicit val graphDecoder: JsonDecoder[DirectedGraph[String]] = DeriveJsonDecoder.gen[DirectedGraph[String]]

  def encodeGraph(graph: DirectedGraph[String]): String = {
    graph.toJson
  }

  def decodeGraph(json: String): Either[String, DirectedGraph[String]] = {
    json.fromJson[DirectedGraph[String]]
  }
}
