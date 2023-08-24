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
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.SwingConstants;

import lombok.Data;

@Data
public class GenericLayoutSplitPane extends JSplitPane {

    public GenericLayoutSplitPane(JPanel panel1, JPanel panel2) {
        super(JSplitPane.VERTICAL_SPLIT, panel1, panel2);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(null);
        setBackground(Color.BLACK);
        setBounds(10, 100, screenSize.width - 20, screenSize.height - 200);

        // set Orientation for slider
        setOrientation(SwingConstants.VERTICAL);

        setOneTouchExpandable(true);

        // set divider location
        setDividerLocation(screenSize.width / 2);

        setVisible(false);
    }
}
