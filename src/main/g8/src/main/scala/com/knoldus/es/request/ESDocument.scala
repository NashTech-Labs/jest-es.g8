package com.knoldus.es.request

case class ESDocument[T](index: String, docType: String, docId: String, obj: T)

