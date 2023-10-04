package com.doc_whisperer.model.enums;

public enum DataArchitecture {

    RELATIONAL_DATABASES("Uses structured schema and SQL to manage and query data. It's ACID-compliant, ensuring reliability in every transaction."),
    NOSQL("NoSQL databases are flexible, scalable, and designed for wide varieties of data models including document, columnar, key-value, and graph."),
    DATA_WAREHOUSES("Central repositories for storing large volumes of data from multiple sources. Optimized for query and analysis."),
    DATA_LAKES("Store a vast amount of raw data in its native format until it's needed. It’s flexible but requires effective data governance."),
    CACHING("Utilizing caching mechanisms like Redis or Memcached to store copies of frequently accessed data, reducing latency and improving performance."),
    STREAMING_BATCH_PROCESSING("Handle data processing tasks either in real-time (streaming) or in batches. It's essential for processing large volumes of data efficiently.");

    private final String description;

    DataArchitecture(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
