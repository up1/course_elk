# Machine Learning in Elasticsearch and Kibana

### Step 1 :: Prepare data
```
// List all indices
GET _cat/indices?v

// Query data
GET kibana_sample_data_flights/_search
GET kibana_sample_data_flights/_search?scroll=1m
```

### Step 2 :: Training model
```
// Create data frame for analyze (choose features/fields)
DELETE _ml/data_frame/analytics/model-flight-delay-classification

PUT _ml/data_frame/analytics/model-flight-delay-classification
{
  "source": {
    "index": [
      "kibana_sample_data_flights"  
    ]
  },
  "dest": {
    "index": "df-flight-delayed",  
    "results_field": "ml" 
  },
  "analysis": {
    "classification": {
      "dependent_variable": "FlightDelay",  
      "training_percent": 10  
    }
  },
  "analyzed_fields": {
    "includes": [],
    "excludes": [    
      "Cancelled",
      "FlightDelayMin",
      "FlightDelayType"
    ]
  },
  "model_memory_limit": "100mb" 
}
```

Start to create model job
```
POST _ml/data_frame/analytics/model-flight-delay-classification/_start
```

Check status of job
```
GET _ml/data_frame/analytics/model-flight-delay-classification/_stats
```

See result of training model
```
GET df-flight-delayed/_search
```

### Step 3 :: Evaluate your model with confusion matrix
```
POST _ml/data_frame/_evaluate
{
  "index": "df-flight-delayed",
  "query": {
    "term": {
      "ml.is_training": {
        "value": false
      }
    }
  },
  "evaluation": {
    "classification": {
      "actual_field": "FlightDelay",
      "predicted_field": "ml.FlightDelay_prediction",
      "metrics": {
        "multiclass_confusion_matrix": {}
      }
    }
  }
}
```
