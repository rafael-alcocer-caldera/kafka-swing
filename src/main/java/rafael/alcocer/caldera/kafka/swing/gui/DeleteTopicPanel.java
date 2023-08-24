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
package rafael.alcocer.caldera.kafka.swing.gui;

import javax.swing.JButton;
import javax.swing.JTextField;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.utils.FontUtils;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;
import rafael.alcocer.caldera.kafka.swing.utils.SizeUitls;

@Data
public class DeleteTopicPanel extends AbstractGenericListPanel {

    private JTextField topicNameTextfield;
    private JButton deleteButton;

    public DeleteTopicPanel() {
        getButton().setText(LabelUtils.LIST_TOPICS);

        topicNameTextfield = new JTextField(25);
        topicNameTextfield.setEditable(false);
        topicNameTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        topicNameTextfield.setBounds(SizeUitls.X_300, SizeUitls.Y_650, SizeUitls.WIDTH_300, SizeUitls.HEIGHT_40);

        deleteButton = new JButton();
        deleteButton.setFont(FontUtils.VERDANA_BOLD_16);
        deleteButton.setText(LabelUtils.DELETE);
        deleteButton.setBounds(SizeUitls.X_10, SizeUitls.Y_650, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        add(topicNameTextfield);
        add(deleteButton);
    }
}
