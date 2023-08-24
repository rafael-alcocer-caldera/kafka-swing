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

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.utils.FontUtils;
import rafael.alcocer.caldera.kafka.swing.utils.SizeUitls;

@Data
public class CreateTopicPanel extends JPanel {

    // Labels
    private JLabel topicNameLabel;
    private JLabel numPartitionsLabel;
    private JLabel replicationFactorLabel;

    // Textfileds
    private JTextField topicNameTextfield;
    private JTextField numPartitionsTextfield;
    private JTextField replicationFactorTextfield;

    // Buttons
    private JButton saveButton;
    private JButton cancelButton;

    public CreateTopicPanel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        topicNameLabel = new JLabel("Topic Name: ");
        topicNameLabel.setFont(FontUtils.VERDANA_BOLD_16);
        topicNameLabel.setBounds(SizeUitls.X_10, SizeUitls.Y_50, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        numPartitionsLabel = new JLabel("Number of partitions: ");
        numPartitionsLabel.setFont(FontUtils.VERDANA_BOLD_16);
        numPartitionsLabel.setBounds(SizeUitls.X_10, SizeUitls.Y_100, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        replicationFactorLabel = new JLabel("Replication factor: ");
        replicationFactorLabel.setFont(FontUtils.VERDANA_BOLD_16);
        replicationFactorLabel.setBounds(SizeUitls.X_10, SizeUitls.Y_150, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        topicNameTextfield = new JTextField(25);
        topicNameTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        topicNameTextfield.setBounds(SizeUitls.X_300, SizeUitls.Y_50, SizeUitls.WIDTH_300, SizeUitls.HEIGHT_40);

        numPartitionsTextfield = new JTextField(25);
        numPartitionsTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        numPartitionsTextfield.setBounds(SizeUitls.X_300, SizeUitls.Y_100, SizeUitls.WIDTH_300, SizeUitls.HEIGHT_40);

        replicationFactorTextfield = new JTextField(25);
        replicationFactorTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        replicationFactorTextfield.setBounds(SizeUitls.X_300, SizeUitls.Y_150, SizeUitls.WIDTH_300,
                SizeUitls.HEIGHT_40);

        saveButton = new JButton();
        saveButton.setFont(FontUtils.VERDANA_BOLD_16);
        saveButton.setText("Save");
        saveButton.setBounds(SizeUitls.X_10, SizeUitls.Y_300, SizeUitls.WIDTH_100, SizeUitls.HEIGHT_40);

        cancelButton = new JButton();
        cancelButton.setFont(FontUtils.VERDANA_BOLD_16);
        cancelButton.setText("Cancel");
        cancelButton.setBounds(SizeUitls.X_300, SizeUitls.Y_300, SizeUitls.WIDTH_100, SizeUitls.HEIGHT_40);

        add(topicNameLabel);
        add(topicNameTextfield);
        add(numPartitionsLabel);
        add(numPartitionsTextfield);
        add(replicationFactorLabel);
        add(replicationFactorTextfield);
        add(saveButton);
        add(cancelButton);
    }
}
