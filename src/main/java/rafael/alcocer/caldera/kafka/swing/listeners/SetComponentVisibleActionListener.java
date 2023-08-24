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
package rafael.alcocer.caldera.kafka.swing.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;

import rafael.alcocer.caldera.kafka.swing.gui.KafkaFrame;

public class SetComponentVisibleActionListener implements ActionListener {

    private final JComponent component;
    private final KafkaFrame kafkaFrame;

    public SetComponentVisibleActionListener(JComponent component, KafkaFrame kafkaFrame) {
        this.component = component;
        this.kafkaFrame = kafkaFrame;
    }

    public void actionPerformed(ActionEvent e) {
        kafkaFrame.cleanConfigurationPanelAll();
        kafkaFrame.cleanDeleteTopicPanel();
        kafkaFrame.cleanListTopicsPanel();
        kafkaFrame.setConfigurationPanelDefaultValues();
        kafkaFrame.setSplitPanesVisible(false);
        component.setVisible(true);
    }
}
