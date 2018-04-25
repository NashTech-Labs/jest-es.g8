package com.knoldus.es.client

import io.searchbox.client.config.HttpClientConfig
import io.searchbox.client.{JestClient, JestClientFactory}

object ESClient {

  lazy val jestClient: JestClient = {

    val factory = new JestClientFactory
    factory.setHttpClientConfig(new HttpClientConfig.Builder("http://localhost:9200").build())
    factory.getObject
  }
}
