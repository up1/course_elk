## Create Elasticsearch cluster with Docker

```
$docker-compose up -d
$docker-compose ps
```

Access to kibana with url = `http://localhost:5601`


### List of nodes in cluster
```
GET _cat/nodes?v

ip         heap.percent ram.percent cpu load_1m load_5m load_15m node.role   master name
172.19.0.4           29         100   6    0.11    1.28     1.13 cdfhilmrstw *      es02
172.19.0.5           45         100   6    0.11    1.28     1.13 cdfhilmrstw -      es03
172.19.0.3           44         100   6    0.11    1.28     1.13 cdfhilmrstw -      es01
```

### [Node Roles](https://www.elastic.co/guide/en/elasticsearch/reference/current/modules-node.html)
* c = data_cold
* d = data
* f = data_frozen
* h = data_hot
* i = ingest
* l = ml
* m = master
* r = remore cluster client
* s = data_content
* t = transform
* w = data_warm
* v = voting_only
* `-` = coordinating