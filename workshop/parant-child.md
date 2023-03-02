## Workshop :: [Parent-children](https://www.elastic.co/guide/en/elasticsearch/reference/current/parent-join.html)
* Order
* User

### Create mapping

```
DELETE order

PUT order
{
  "mappings": {
    "properties": {
      "user_order_join_field": {
        "type": "join",
        "relations": {
          "order": "user"
        }
      }
    }
  }
}
```

### Indexing parent : Order
```
POST order/_doc/1?routing=123
{
  "id": 1,
  "amount": 5,
  "price": 1000,
  "user_order_join_field":{
    "name": "order"
  }
}
```
### Indexing children : User
```
PUT order/_doc/123?routing=123&refresh 
{
  "id": 123,
  "name": "somkiat",
  "email": "xxx@xxx.com",
  "mobile": "0888888888",
  "user_order_join_field": {
    "name": "user", 
    "parent": 1 
  }
}
```

### Query data :: order
```
GET order/_search
{
  "query": {
    "has_child": {
      "type": "user",
      "query": {
        "term": {
          "id": {
            "value": 123
          }
        }
      }
    }
  }
}
```

### Query data :: user
```
GET order/_search
{
  "query": {
    "has_parent": {
      "parent_type": "order",
      "query": {
        "term": {
          "id": {
            "value": 1
          }
        }
      }
    }
  }
}
```
