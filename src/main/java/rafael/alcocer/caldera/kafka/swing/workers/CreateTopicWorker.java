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

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import org.apache.kafka.clients.admin.CreateTopicsResult;

import rafael.alcocer.caldera.kafka.swing.controller.TopicController;
import rafael.alcocer.caldera.kafka.swing.controller.TopicControllerImpl;
import rafael.alcocer.caldera.kafka.swing.gui.KafkaFrame;
import rafael.alcocer.caldera.kafka.swing.service.AdminSingleton;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

public class CreateTopicWorker extends SwingWorker<CreateTopicsResult, Void> {

    private final KafkaFrame kafkaFrame;
    private final TopicController topicController = new TopicControllerImpl();

    public CreateTopicWorker(KafkaFrame kafkaFrame) {
        this.kafkaFrame = kafkaFrame;
    }

    @Override
    protected CreateTopicsResult doInBackground() throws Exception {
        kafkaFrame.cleanConfigurationPanel();
        kafkaFrame.setSplitPanesVisible(false);
        kafkaFrame.getCreateTopicSplitPane().setVisible(true);

        if (AdminSingleton.getAdmin() == null) {
            return null;
        }

        return topicController.createTopic(kafkaFrame.getCreateTopicPanel().getTopicNameTextfield().getText(),
                Integer.parseInt(kafkaFrame.getCreateTopicPanel().getNumPartitionsTextfield().getText()),
                Short.parseShort(kafkaFrame.getCreateTopicPanel().getReplicationFactorTextfield().getText()));
    }

    @Override
    protected void done() {
        if (AdminSingleton.getAdmin() == null) {
            kafkaFrame.getCreateTopicResultPanel().getLabel().setText(LabelUtils.YOU_ARE_NOT_CONNECTED);

            kafkaFrame.revalidate();
            kafkaFrame.repaint();

            return;
        }

        try {
            CreateTopicsResult createTopicsResult = get();

            kafkaFrame.getCreateTopicResultPanel().getTextArea().setText(LabelUtils.TOPIC_CREATED);
            kafkaFrame.getCreateTopicResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getCreateTopicResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getCreateTopicResultPanel().getTextArea()
                    .append(createTopicsResult.values().keySet().toString());
        } catch (InterruptedException | ExecutionException e) {
            kafkaFrame.getCreateTopicResultPanel().getTextArea().setText(e.getMessage());
            e.printStackTrace();
        }

        kafkaFrame.revalidate();
        kafkaFrame.repaint();
    }
}
