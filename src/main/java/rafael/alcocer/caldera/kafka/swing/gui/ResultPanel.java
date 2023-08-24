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

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.utils.ColorUtils;
import rafael.alcocer.caldera.kafka.swing.utils.FontUtils;
import rafael.alcocer.caldera.kafka.swing.utils.SizeUitls;

@Data
public class ResultPanel extends JPanel {

    private JTextArea textArea;
    private JLabel label;

    public ResultPanel() {
        setLayout(null);
        setBackground(ColorUtils.VERY_DARK_GREY);

        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setFont(FontUtils.VERDANA_BOLD_16);
        textArea.setBackground(Color.LIGHT_GRAY);
        textArea.setForeground(Color.BLACK);
        textArea.setBounds(SizeUitls.X_10, SizeUitls.Y_10, SizeUitls.HALF_SCREEN_WIDTH_LESS_50,
                SizeUitls.HALF_SCREEN_HEIGHT_PLUS_100);

        label = new JLabel();
        label.setBackground(Color.BLACK);
        label.setForeground(Color.YELLOW);
        label.setFont(FontUtils.VERDANA_BOLD_20);
        label.setBounds(SizeUitls.X_10, SizeUitls.Y_600, SizeUitls.WIDTH_500, SizeUitls.HEIGHT_40);

        add(textArea);
        add(label);
    }
}
