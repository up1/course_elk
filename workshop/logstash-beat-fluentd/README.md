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

1. Install plugins of Fluentd
```
$/opt/td-agent/embedded/bin/fluent-gem install fluent-plugin-beats --no-document
$/opt/td-agent/embedded/bin/fluent-gem install fluent-plugin-elasticsearch --no-document
$/opt/td-agent/embedded/bin/fluent-gem install fluent-plugin-concat --no-document
```

2. Config Fluentd (MacOS)

Edit file `/etc/td-agent/td-agent.conf` 
```
// Reload config
$sudo launchctl unload /Library/LaunchDaemons/td-agent.plist
$sudo launchctl load /Library/LaunchDaemons/td-agent.plist

//See log
$tail -100f /var/log/td-agent/td-agent.log
```

3. Start FileBeat
```
$cd fluentd
$filebeat -e -c beat-demo.yml -d "publish"
```


Reference Websites
* https://github.com/repeatedly/fluent-plugin-beats
* https://github.com/uken/fluent-plugin-elasticsearch
* https://github.com/fluent-plugins-nursery/fluent-plugin-concat