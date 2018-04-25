A [Giter8][g8] template for Jest Client!

Jest provides an implementation of the Elasticsearch REST API. It is a Java HTTP Rest client for ElasticSearch.  It’s API is similar to Elasticsearch API.

Pre-requisite for running project:</br> 
ElasticSearch should be up and running. You can download it from https://www.elastic.co/downloads/elasticsearch. Elasticsearch runs on port 9200.</br>
To run this project:</br>
1. cd src/main/g8
2. sbt clean compile run

We can also visualize the data using Kibana. Kibana is an open source analytics and visualization platform designed to work with Elasticsearch. You use Kibana to search, view, and interact with data stored in Elasticsearch indices. you can download Kibana from https://www.elastic.co/downloads/kibana.

To see data is inserted or not we can query on kibana console:
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

For more details refere to:
https://blog.knoldus.com/2018/02/13/exploring-jest-java-http-rest-client/</br>

Template license
----------------
Written in <YEAR> by <AUTHOR NAME> <AUTHOR E-MAIL ADDRESS>
[other author/contributor lines as appropriate]

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/
