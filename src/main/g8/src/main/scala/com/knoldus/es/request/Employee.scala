package com.knoldus.es.request

import play.api.libs.json.{Format, Json}

case class Employee(name: String, project: String, id: String)

object Employee {
  implicit val format: Format[Employee] = Json.format
}

