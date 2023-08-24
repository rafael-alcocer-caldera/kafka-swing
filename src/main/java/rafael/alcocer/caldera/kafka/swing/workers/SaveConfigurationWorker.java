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

import org.apache.kafka.clients.admin.Admin;

import rafael.alcocer.caldera.kafka.swing.controller.ConfigurationController;
import rafael.alcocer.caldera.kafka.swing.controller.ConfigurationControllerImpl;
import rafael.alcocer.caldera.kafka.swing.gui.KafkaFrame;
import rafael.alcocer.caldera.kafka.swing.model.Configuration;

public class SaveConfigurationWorker extends SwingWorker<Admin, Void> {

    private final KafkaFrame kafkaFrame;
    private final Configuration configuration = new Configuration();
    private final ConfigurationController configurationController = new ConfigurationControllerImpl();

    public SaveConfigurationWorker(KafkaFrame kafkaFrame) {
        this.kafkaFrame = kafkaFrame;
    }

    @Override
    protected Admin doInBackground() throws Exception {
        if (kafkaFrame.getConfigurationPanel().getApplicationIdTextfield().getText().equals("")
                && kafkaFrame.getConfigurationPanel().getBootstrapServersTextfield().getText().equals("")) {

            return null;
        }

        configuration.setApplicationId(kafkaFrame.getConfigurationPanel().getApplicationIdTextfield().getText());
        configuration.setBootstrapServers(kafkaFrame.getConfigurationPanel().getBootstrapServersTextfield().getText());

        return configurationController.saveConfiguration(configuration);
    }

    @Override
    protected void done() {        
        try {
            if (get() == null) {
                kafkaFrame.getConfigurationResultPanel().getTextArea().setText("Bootstrap Servers must not be empty");
                
                kafkaFrame.revalidate();
                kafkaFrame.repaint();
                
                return;
            }
            
            Admin admin = get();

            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .setText("Cluster Id: " + admin.describeCluster().clusterId().get());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("Cluster Id: " + admin.describeCluster().clusterId().toString());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append("Nodes: " + admin.describeCluster().nodes());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("Controller: " + admin.describeCluster().controller());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("authorizedOperations: " + admin.describeCluster().authorizedOperations());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("describeFeatures: " + admin.describeFeatures());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("describeFeatures... featureMetadata: " + admin.describeFeatures().featureMetadata());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("listConsumerGroups: " + admin.listConsumerGroups());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("listPartitionReassignments: " + admin.listPartitionReassignments());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append("listTopics: " + admin.listTopics());
            kafkaFrame.getConfigurationResultPanel().getTextArea().append(System.lineSeparator());
            kafkaFrame.getConfigurationResultPanel().getTextArea()
                    .append("listTopics.names: " + admin.listTopics().names());
            
            kafkaFrame.getConfigurationResultPanel().getLabel()
            .setText("Connected: " + admin.describeCluster().clusterId().get());
            
            kafkaFrame.cleanConfigurationPanel();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        kafkaFrame.revalidate();
        kafkaFrame.repaint();
    }
}
