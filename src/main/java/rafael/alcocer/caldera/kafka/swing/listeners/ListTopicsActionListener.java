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

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;

import rafael.alcocer.caldera.kafka.swing.workers.ListTopicsWorker;

public class ListTopicsActionListener implements ActionListener {

    private final DefaultListModel<String> model;
    private final JList<String> list;
    private final JLabel label;

    public ListTopicsActionListener(DefaultListModel<String> model, JList<String> list, JLabel label) {
        this.model = model;
        this.list = list;
        this.label = label;
    }

    public void actionPerformed(ActionEvent e) {
        ListTopicsWorker listTopicsWorker = new ListTopicsWorker(model, list, label);
        listTopicsWorker.execute();
    }
}
