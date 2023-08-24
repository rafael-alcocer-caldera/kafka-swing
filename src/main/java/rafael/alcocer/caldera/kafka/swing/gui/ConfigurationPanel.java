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
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;
import rafael.alcocer.caldera.kafka.swing.utils.SizeUitls;

@Data
public class ConfigurationPanel extends JPanel {

    private JLabel applicationIdLabel;
    private JLabel bootstrapServersLabel;

    private JTextField applicationIdTextfield;
    private JTextField bootstrapServersTextfield;

    private JButton connectButton;
    private JButton cancelButton;

    public ConfigurationPanel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        applicationIdLabel = new JLabel(LabelUtils.APPLICATION_ID);
        applicationIdLabel.setFont(FontUtils.VERDANA_BOLD_16);
        applicationIdLabel.setBounds(SizeUitls.X_10, SizeUitls.Y_50, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        bootstrapServersLabel = new JLabel(LabelUtils.BOOTSTRAP_SERVERS);
        bootstrapServersLabel.setFont(FontUtils.VERDANA_BOLD_16);
        bootstrapServersLabel.setBounds(SizeUitls.X_10, SizeUitls.Y_100, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        applicationIdTextfield = new JTextField(25);
        applicationIdTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        applicationIdTextfield.setBounds(SizeUitls.X_200, SizeUitls.Y_50, SizeUitls.WIDTH_500, SizeUitls.HEIGHT_40);

        bootstrapServersTextfield = new JTextField(25);
        bootstrapServersTextfield.setFont(FontUtils.VERDANA_BOLD_16);
        bootstrapServersTextfield.setBounds(SizeUitls.X_200, SizeUitls.Y_100, SizeUitls.WIDTH_500, SizeUitls.HEIGHT_40);

        connectButton = new JButton();
        connectButton.setFont(FontUtils.VERDANA_BOLD_16);
        connectButton.setText(LabelUtils.CONNECT);
        connectButton.setBounds(SizeUitls.X_10, SizeUitls.Y_300, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        cancelButton = new JButton();
        cancelButton.setFont(FontUtils.VERDANA_BOLD_16);
        cancelButton.setText(LabelUtils.CANCEL);
        cancelButton.setBounds(SizeUitls.X_300, SizeUitls.Y_300, SizeUitls.WIDTH_100, SizeUitls.HEIGHT_40);

        add(applicationIdLabel);
        add(applicationIdTextfield);
        add(bootstrapServersLabel);
        add(bootstrapServersTextfield);
        add(connectButton);
        add(cancelButton);
    }
}
