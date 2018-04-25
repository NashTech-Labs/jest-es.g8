package com.knoldus.es.OperationProcessor

import com.knoldus.es.esoperations.ElasticSearchOperations
import com.knoldus.es.request.{ESDocument, Employee}

object Processor extends ElasticSearchOperations with App {
  val emp1 = Employee("Shivangi", "opay", "1")
  val emp2 = Employee("Divya", "opay", "2")
  val emp3 = Employee("Akhil", "opay", "3")
  val emp4 = Employee("Akhil", "opay", "4")
  val eSDocument1 = ESDocument[Employee]("company", "employee", emp1.id, emp1)
  val eSDocument2 = ESDocument[Employee]("company", "employee", emp2.id, emp3)
  val eSDocument3 = ESDocument[Employee]("company", "employee", emp3.id, emp3)
  val eSDocument4 = ESDocument[Employee]("company", "employee", emp4.id, emp4)
  logger.info("Inserting in ElasticSearch")
  val result1 = insertInES(eSDocument1)
  logger.info("Result is: " + result1)
  val result2 = insertInES(eSDocument2)
  logger.info("Result is: " + result2)
  val result3 = insertInES(eSDocument3)
  logger.info("Result is: " + result3)
  val result4 = insertInES(eSDocument4)
  logger.info("Result is: " + result4)

  /*  logger.info("---Getting data from ElasticSearch---")
    val searchRes = search("company", "employee")
    logger.info("match all query result: " + searchRes)*/
  /*
  
    logger.info("----- Updating data in ElasticSearch ---------")
    val emp5 = Employee("Shivangi Gupta", "opay", "1")
    val eSDocument5 = ESDocument[Employee]("company", "employee", emp5.id, emp5)
    update(eSDocument5, "company", "employee")

    logger.info("Deleting from Elastic search: ")
    delete("company")*/
}
