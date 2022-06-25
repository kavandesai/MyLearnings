package com.example;

import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemoKeys {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemoKeys.class.getSimpleName());

    public static void main(String[] args) {
        log.info("Kafka Producer");
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"172.30.100.67:9092");
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class.getName());

        KafkaProducer<String ,String > producer = new KafkaProducer<String, String>(properties);

        for (int i=0;i<10;i++) {

            String topic = "demo-java";
            String value = "hello_world" + i;
            String key = "id " + i;
            ProducerRecord<String, String> producerRecord = new ProducerRecord<>(topic, key, value);
            producer.send(producerRecord, new Callback() {
                @Override
                public void onCompletion(RecordMetadata metadata, Exception exception) {
                    if (exception == null) {
                        log.info("Received new metadata");
                        log.info("Topic name " + metadata.topic());
                        log.info("Key" + producerRecord.key());
                        log.info("Partition" + metadata.partition());
                        log.info("Offset" + metadata.offset());
                    } else {
                        log.error(exception.getMessage());
                    }
                }
            });
        }
            producer.flush();
            producer.close();
        }

    }

