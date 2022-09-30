## Create [Elasticsearch cluster with Docker](https://www.elastic.co/guide/en/elasticsearch/reference/current/docker.html)

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

## Design for resilient
* Master node >= 3
  * node.roles: [ master ]
* Data node >= 2
  * node.roles: [ data ]
* Query or coordinating node >= 2
  * node.roles: [ ]
* Replication >= 1 (at lease data node = 2)

```
$docker-compose -f docker-compose-roles.yml up -d
$docker-compose -f docker-compose-roles.yml ps

    Name                   Command                  State                             Ports
------------------------------------------------------------------------------------------------------------------
demo_es01_1     /bin/tini -- /usr/local/bi ...   Up (healthy)   0.0.0.0:9200->9200/tcp,:::9200->9200/tcp, 9300/tcp
demo_es02_1     /bin/tini -- /usr/local/bi ...   Up (healthy)   9200/tcp, 9300/tcp
demo_es03_1     /bin/tini -- /usr/local/bi ...   Up (healthy)   9200/tcp, 9300/tcp
demo_es04_1     /bin/tini -- /usr/local/bi ...   Up (healthy)   9200/tcp, 9300/tcp
demo_es05_1     /bin/tini -- /usr/local/bi ...   Up (healthy)   9200/tcp, 9300/tcp
demo_kibana_1   /bin/tini -- /usr/local/bi ...   Up (healthy)   0.0.0.0:5601->5601/tcp,:::5601->5601/tcp
demo_setup_1    /bin/tini -- /usr/local/bi ...   Exit 0
```

### List of nodes in cluster
```
GET _cat/nodes?v

ip           heap.percent ram.percent cpu load_1m load_5m load_15m node.role master name
192.168.64.3           56          93  61    5.62    3.58     1.83 m         *      es01
192.168.64.6           28          97  67    5.62    3.58     1.83 d         -      es03
192.168.64.4           62          91  68    5.62    3.58     1.83 m         -      es02
192.168.64.7           30          90  68    5.62    3.58     1.83 -         -      es04
192.168.64.5           35          90  66    5.62    3.58     1.83 -         -      es05
```

## References
* [Set up a cluster for high availability](https://www.elastic.co/guide/en/elasticsearch/reference/current/high-availability.html)
* [Plan for production](https://www.elastic.co/guide/en/cloud/current/ec-planning.html)
* [Designing for resilience](https://www.elastic.co/guide/en/elasticsearch/reference/current/high-availability-cluster-design.html)

