/**
 * Copyright [2023] [RAFAEL ALCOCER CALDERA]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package components;

import java.util.Properties;
import java.util.UUID;

import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.KeyValueMapper;

public class RacConsumer {
    
    public static void main(String[] args) {
        RacConsumer racConsumer = new RacConsumer();
        racConsumer.go();
    }

    public void go() {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, UUID.randomUUID().toString());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        
        StreamsBuilder streamsBuilder = new StreamsBuilder();
        KStream<String, String> kstream = streamsBuilder.stream("rac-topic");
        kstream.groupBy(new KeyValueMapper<String, String, String>() {

            @Override
            public String apply(String key, String value) {
                System.out.println("##### key: " + key);
                System.out.println("##### value: " + value);
                return key.toUpperCase();
            }
        });
       
        
        KafkaStreams kafkaStreams = new KafkaStreams(streamsBuilder.build(), props);
        
        kafkaStreams.start();
    }
}
