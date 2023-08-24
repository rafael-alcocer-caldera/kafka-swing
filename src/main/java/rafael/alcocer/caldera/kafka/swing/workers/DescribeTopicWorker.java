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
package rafael.alcocer.caldera.kafka.swing.workers;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.kafka.clients.admin.DescribeTopicsResult;
import org.apache.kafka.clients.admin.TopicDescription;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.TopicPartitionInfo;

import rafael.alcocer.caldera.kafka.swing.service.AdminSingleton;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

public class DescribeTopicWorker extends SwingWorker<DescribeTopicsResult, Void> {

    private final JTextArea textArea;
    private final String topicName;

    public DescribeTopicWorker(JTextArea textArea, String topicName) {
        this.textArea = textArea;
        this.topicName = topicName;
    }

    @Override
    protected DescribeTopicsResult doInBackground() throws Exception {
        return describeTopics(topicName);
    }

    @Override
    protected void done() {
        textArea.updateUI();
    }

    private DescribeTopicsResult describeTopics(String topic) {
        DescribeTopicsResult result = AdminSingleton.getAdmin().describeTopics(Collections.singletonList(topic));

        result.values().entrySet().forEach(entry -> {
            KafkaFuture<TopicDescription> des = entry.getValue();

            try {
                textArea.setText(LabelUtils.TOPIC_DESCRIPTION);
                textArea.append(System.lineSeparator());
                textArea.append("-------------------");
                textArea.append(System.lineSeparator());
                textArea.append(LabelUtils.NAME + des.get().name());
                textArea.append(System.lineSeparator());
                textArea.append(LabelUtils.TOPIC_ID + des.get().topicId());
                textArea.append(System.lineSeparator());
                textArea.append(LabelUtils.IS_INTERNAL_TO_KAFKA + des.get().isInternal());
                textArea.append(System.lineSeparator());
                textArea.append(System.lineSeparator());
                textArea.append(LabelUtils.TOPIC_PARTITIONS);
                textArea.append(System.lineSeparator());
                textArea.append("-----------------");
                textArea.append(System.lineSeparator());

                List<TopicPartitionInfo> list = des.get().partitions();

                list.forEach(topicPartitionInfo -> {
                    textArea.append(LabelUtils.PARTITION + topicPartitionInfo.partition());
                    textArea.append(System.lineSeparator());
                    textArea.append(LabelUtils.IN_SYNC_REPLICAS + topicPartitionInfo.isr());
                    textArea.append(System.lineSeparator());
                    textArea.append(LabelUtils.LEADER + topicPartitionInfo.leader());
                    textArea.append(System.lineSeparator());
                    textArea.append(LabelUtils.REPLICAS + topicPartitionInfo.replicas());
                });
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });

        return result;
    }
}
