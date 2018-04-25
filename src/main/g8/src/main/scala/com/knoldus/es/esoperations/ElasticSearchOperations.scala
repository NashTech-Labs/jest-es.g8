package com.knoldus.es.esoperations

import java.lang
import java.util.logging.Logger

import com.knoldus.es.client.ESClient
import com.knoldus.es.request.{ESDocument, Response}

import io.searchbox.client.JestClient
import io.searchbox.core._
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.builder.SearchSourceBuilder
import play.api.libs.json.Json

/**
  * Performs Create, Read, Update and Delete operation on ES
  */
trait ElasticSearchOperations {

  val client: JestClient = ESClient.jestClient

  val logger: Logger = Logger.getLogger("ElasticSearchOperations")

  /**
    * creates an index in ElasticSearch if it does not exists otherwise it inserts data in elasticSearch
    *
    * @param eSDocument Document to be inserted in ES
    * @param tjs
    * @tparam T
    * @return
    */
  def insertInES[T](eSDocument: ESDocument[T])(implicit tjs: play.api.libs.json.Writes[T]): Response = {
    val source = Json.stringify(Json.toJson(eSDocument.obj))
    logger.info("creating index in ElasticSearch")
    val index: Index = new Index.Builder(source)
      .index(eSDocument.index)
      .`type`(eSDocument.docType)
      .id(eSDocument.docId)
      .build()
    logger.info("executing the client")
    val response = client.execute(index)
    if (response.getErrorMessage == null)
      Response(done = true)
    else
      Response(done = false)
  }

  /**
    * Searches in ElasticSearch
    *
    * @param index   index to be searched
    * @param docType document to be searched
    * @return
    */
  def search(index: String, docType: String): lang.Long = {
    logger.info("build query with QueryBuilder")
    val searchSourceBuilder: SearchSourceBuilder = new SearchSourceBuilder()
    val query = searchSourceBuilder.query(QueryBuilders.matchAllQuery())
    logger.info("Query:: " + query.toString)
    val search = new Search.Builder(query.toString).addIndex(index).addType(docType).build()
    client.execute(search).getTotal
  }

  /**
    * Update the ES wih the new document
    *
    * @param eSDocument new document to be inserted
    * @param index      index to be updated
    * @param docType    document to be updated
    * @param tjs
    * @tparam T
    * @return
    */
  def update[T](eSDocument: ESDocument[T], index: String, docType: String)(implicit tjs: play.api.libs.json.Writes[T]): Response = {
    val source = Json.stringify(Json.toJson(eSDocument.obj))
    val updateQuery = new Update.Builder(source).index(index).`type`(docType).build()
    val updationResponse = client.execute(updateQuery)
    if (updationResponse.getErrorMessage == null)
      Response(done = true)
    else
      Response(done = false)
  }

  /**
    * Deletes specified index from ES
    *
    * @param index index to be deleted
    * @return
    */
  def delete(index: String): Response = {
    val deleteRequest = new Delete.Builder("").index(index).build()
    val deletionResponse = client.execute(deleteRequest)
    if (deletionResponse.getErrorMessage == null)
      Response(done = true)
    else
      Response(done = false)
  }
}
