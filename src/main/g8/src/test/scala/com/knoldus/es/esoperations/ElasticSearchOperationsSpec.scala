package com.knoldus.es.esoperations

import com.google.gson.{Gson, JsonParser}
import com.knoldus.es.request.{ESDocument, Employee}
import io.searchbox.client.JestClient
import io.searchbox.core.{DocumentResult, SearchResult}
import org.mockito.ArgumentMatchers
import org.mockito.Mockito.when
import org.scalatest.WordSpecLike
import org.scalatest.mockito.MockitoSugar

class ElasticSearchOperationsSpec extends ElasticSearchOperations with WordSpecLike with MockitoSugar {

  val resultJson: String = "{\"_shards\": {\"total\": 5,\"successful\": 5,\"failed\": 0},\"hits\": {\"total\": 1," +
    "\"max_score\": 1,\"hits\": []}}"
  val searchResult = new SearchResult(new Gson)
  searchResult.setSucceeded(true)
  searchResult.setJsonString(resultJson)
  searchResult.setJsonObject(new JsonParser().parse(resultJson).getAsJsonObject)
  searchResult.setPathToResult("hits/hits/_source")

  override val client: JestClient = mock[JestClient]
  val mockDocumentResult: DocumentResult = mock[DocumentResult]
  val emp = Employee("Shivangi", "opay", "1")
  val eSDocument1: ESDocument[Employee] = ESDocument[Employee]("company", "employee", emp.id, emp)
  val index = "company"

  "ElasticSearchOperationsSpec" should {
    "test whether Elastic Search Index is created or not" in {
      when(client.execute(ArgumentMatchers.anyObject())) thenReturn mockDocumentResult
      val result = insertInES(eSDocument1)
      assert(result.done)
    }

    "test whether search query is processed by elastic search or not" in {
      when(client.execute(ArgumentMatchers.anyObject())) thenReturn searchResult
      val searchQuery = """{"query" : {"match_all" : {"boost" : 1.0 } } }""".stripMargin
      val response = search(index, searchQuery)
      assert(response == 1)
    }

    "test whether elastic search is updated or not" in {
      when(client.execute(ArgumentMatchers.anyObject())) thenReturn mockDocumentResult
      val emp = Employee("Shivangi Gupta", "opay", "1")
      val eSDocument5 = ESDocument[Employee]("company", "employee", emp.id, emp)
      val updationResponse = update(eSDocument5, "company", "employee")
      assert(updationResponse.done)
    }

    "test whether deletion is working fine or not" in {
      when(client.execute(ArgumentMatchers.anyObject())) thenReturn mockDocumentResult
      val deleteResult = delete(index)
      assert(deleteResult.done)
    }

  }
}
