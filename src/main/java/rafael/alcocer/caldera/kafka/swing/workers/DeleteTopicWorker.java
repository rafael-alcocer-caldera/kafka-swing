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

import org.apache.kafka.clients.admin.DeleteTopicsResult;

import rafael.alcocer.caldera.kafka.swing.controller.TopicController;
import rafael.alcocer.caldera.kafka.swing.controller.TopicControllerImpl;
import rafael.alcocer.caldera.kafka.swing.gui.KafkaFrame;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

/**
 * AccessDeniedException al eliminar un tema en Windows Kafka
 * https://www.it-swarm-es.com/es/windows/accessdeniedexception-al-eliminar-un-tema-en-windows-kafka/838019579/
 * 
 * Tuve un problema similar y solo ocurre bajo Windows, vea KAFKA-1194 y todav�a
 * se aplica a Kafka 1.1.0
 * 
 * La �nica soluci�n disponible es deshabilitar el limpiador log.cleaner.enable
 * = false
 * 
 * Para el desarrollo local en Windows, puede ignorar este problema, ya que no
 * se aplica en otros sistemas operativos.
 * 
 * @author RAC
 *
 */
public class DeleteTopicWorker extends SwingWorker<DeleteTopicsResult, Void> {

    private final KafkaFrame kafkaFrame;
    private final TopicController topicController = new TopicControllerImpl();

    public DeleteTopicWorker(KafkaFrame kafkaFrame) {
        this.kafkaFrame = kafkaFrame;
    }

    @Override
    protected DeleteTopicsResult doInBackground() throws Exception {
        if (!kafkaFrame.getDeleteTopicPanel().getTopicNameTextfield().getText().isEmpty()) {
            return topicController.deleteTopic(kafkaFrame.getDeleteTopicPanel().getTopicNameTextfield().getText());
        }

        return null;
    }

    @Override
    protected void done() {
        try {
            if (get() == null) {
                kafkaFrame.getDeleteTopicResultPanel().getTextArea().setText(LabelUtils.SELECT_THE_TOPIC_TO_BE_DELETED);
            } else {
                kafkaFrame.getDeleteTopicResultPanel().getTextArea().setText(LabelUtils.DELETED + get().values());
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        kafkaFrame.revalidate();
        kafkaFrame.repaint();
    }
}
