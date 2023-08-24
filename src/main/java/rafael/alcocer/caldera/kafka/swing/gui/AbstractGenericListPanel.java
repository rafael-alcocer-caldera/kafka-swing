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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.utils.FontUtils;
import rafael.alcocer.caldera.kafka.swing.utils.SizeUitls;

@Data
public abstract class AbstractGenericListPanel extends JPanel {

    private JList<String> list;
    private DefaultListModel<String> model;
    private JScrollPane scrollPane;
    private JButton button;
    private JLabel label;

    public AbstractGenericListPanel() {
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        model = new DefaultListModel<String>();

        list = new JList<String>(model);
        list.setFont(FontUtils.VERDANA_BOLD_16);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setLayoutOrientation(JList.VERTICAL);

        scrollPane = new JScrollPane(list);
        scrollPane.setBounds(SizeUitls.X_10, SizeUitls.Y_10, SizeUitls.HALF_SCREEN_WIDTH_LESS_50,
                SizeUitls.HALF_SCREEN_HEIGHT_PLUS_100);

        button = new JButton();
        button.setFont(FontUtils.VERDANA_BOLD_16);
        button.setBounds(SizeUitls.X_10, SizeUitls.Y_600, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        label = new JLabel();
        label.setFont(FontUtils.VERDANA_BOLD_16);
        label.setBounds(SizeUitls.X_300, SizeUitls.Y_600, SizeUitls.WIDTH_200, SizeUitls.HEIGHT_40);

        add(scrollPane);
        add(button);
        add(label);
    }
}
