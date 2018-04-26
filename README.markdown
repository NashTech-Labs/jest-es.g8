A [Giter8][g8] template for Jest Client.

Jest provides an implementation of the Elasticsearch REST API. It is a Java HTTP Rest client for ElasticSearch.  It’s API is similar to Elasticsearch API.

**Pre-requisite for running the project**

ElasticSearch should be up and running. You can download it from [here](https://www.elastic.co/downloads/elasticsearch). Elasticsearch runs on port 9200.

**How to setup ?**

**1) Clone the application**
  
  `sbt new knoldus/jest-es.g8`
  
  **2 Give name to your application**
    
    name jest //you could give any name for example jest 

**3) Compile and run the application**
  
    cd jest
    sbt clean compile 
    sbt run 
 
 **4) Test the application**
    
    sbt clean test 


We can also visualize the data using Kibana. Kibana is an open source analytics and visualization platform designed to work with Elasticsearch. You use Kibana to search, view, and interact with data stored in Elasticsearch indices. 
You can download Kibana from [here](https://www.elastic.co/downloads/kibana).

**To see data is inserted or not we can query on kibana console:**
1. GET /_cat/indices?v
- will show the created indexes
2. GET company/_search
GET company/_search
{
  "query": {
    "match_all": {}
  }
}
- will show all the values of company index

For more details [refer](https://blog.knoldus.com/2018/02/13/exploring-jest-java-http-rest-client/)

Template license
----------------
Written in <2018> by <Shivangi Gupta> <shivangi1015@gmail.com>

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
