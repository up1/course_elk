## Workshop with [nested](https://www.elastic.co/guide/en/elasticsearch/reference/current/nested.html)

### Create mapping
```
DELETE user

PUT user
{
  "mappings": {
    "properties": {
      "orders": {
        "type": "nested"
      }
    }
  }
}
```

### Indexing data :: user with orders
```
PUT user/_doc/123
{
  "id": 123,
  "name": "somkiat",
  "email": "xxx@xxx.com",
  "mobile": "0888888888",
  "orders": [
    {
      "id": 1,
      "amount": 5,
      "price": 1000
    },
    {
      "id": 2,
      "amount": 2,
      "price": 2000
    }
  ]
}
```

### Search data
```
GET user/_search
{
  "query": {
    "nested": {
      "path": "orders",
      "query": {
        "match_all": {}
      }
    }
  }
}
```
