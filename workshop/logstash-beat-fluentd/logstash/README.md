## Working with Logstash
* Working with input and output
* Working with filter
* Working with elasticsearch log

```
$cd logstash
$logstash -f demo.conf
```

## Working with FileBeat + Logstash

```
$cd beat
// Start logstash
$logstash -f logstash-demo.conf

// Start filebeat
$filebeat -e -c beat-demo.yml -d "publish"
```

## Working with Fluentd