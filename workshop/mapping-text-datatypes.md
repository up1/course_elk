## Workshop with dynamic mapping of [text data types](https://www.elastic.co/guide/en/elasticsearch/reference/current/text.html)
* Text
* Keyword
* match_only_text


### Working with dynamic mapping
```
DELETE user

PUT user/_doc/123
{
  "id": "123",
  "name": "somkiat",
  "email": "xxx@xxx.com",
  "mobile": "0888888888"
}

GET user/_mapping

```

### Working with pre-defined mapping

```
DELETE user 

PUT user
{
  "mappings": {
    "properties": {
      "email": {
        "type": "keyword"
      },
      "mobile": {
        "type": "keyword"
      },
      "message": {
        "type": "match_only_text"
      }
    }
  }
}

GET user/_mapping
```

### Indexing data
```
PUT user/_doc/123
{
  "id": "123",
  "name": "somkiat",
  "email": "xxx@xxx.com",
  "mobile": "0888888888",
  "message": "try with new message !!"
}
```

### Search data with keyword/text
```
GET user/_search
{
  "query": {
    "match": {
      "email": "xxx@xxx.com"
    }
  }
}
```

### Search data with match_only_text (calculate score)
```
GET user/_search
{
  "query": {
    "match": {
      "message": "try"
    }
  }
}
```
