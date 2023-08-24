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
package rafael.alcocer.caldera.kafka.swing.service;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.DeleteTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;

public class TopicServiceImpl implements TopicService {

    @Override
    public CreateTopicsResult createTopic(String topicName, int numPartitions, short replicationFactor) {
        NewTopic createTopic = new NewTopic(topicName, numPartitions, replicationFactor);

        return AdminSingleton.getAdmin().createTopics(Collections.singleton(createTopic));
    }

    @Override
    public DeleteTopicsResult deleteTopic(String topic) {
        return AdminSingleton.getAdmin().deleteTopics(Collections.singleton(topic));
    }

    @Override
    public void describeTopic() {
        // TODO Auto-generated method stub

    }

    @Override
    public Set<String> listTopics() throws InterruptedException, ExecutionException {
        return AdminSingleton.getAdmin().listTopics().names().get();
    }
}
