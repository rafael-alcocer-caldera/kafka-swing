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

import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import rafael.alcocer.caldera.kafka.swing.workers.SelectToDeleteTopicWorker;

public class SelectToDeleteTopicSelectionListener implements ListSelectionListener {

    private final JTextField textField;

    public SelectToDeleteTopicSelectionListener(JTextField textField) {
        this.textField = textField;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void valueChanged(ListSelectionEvent e) {
        JList<String> list = (JList<String>) e.getSource();

        if (list.getSelectedValue() != null) {
            SelectToDeleteTopicWorker selectToDeleteTopicWorker = new SelectToDeleteTopicWorker(textField,
                    list.getSelectedValue());
            selectToDeleteTopicWorker.execute();
        }
    }
}
