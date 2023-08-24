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
package rafael.alcocer.caldera.kafka.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Main {

    public static void main(String[] args) {
        JPanel gui = new JPanel(new BorderLayout(2, 3));

        JPanel buttonConstrsint = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton getQuotesButton = new JButton("Load");
        buttonConstrsint.add(getQuotesButton);
        gui.add(buttonConstrsint, BorderLayout.NORTH);

        getQuotesButton.addActionListener(e->{
            String[] columnNames = { "First Name", "Last Name", "Sport",
                "# of Years", "Vegetarian" };

            Object[][] data = {
                { "A", "B", "Snowboarding", new Integer(5),
                    new Boolean(false) },
                { "C", "D", "Pool", new Integer(10), new Boolean(false) } };

            JTable table = new JTable(data, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);

            gui.add(scrollPane, BorderLayout.CENTER);
            gui.revalidate();
            gui.repaint();
        });

        JOptionPane jOptionPane = new JOptionPane(gui);

        JDialog dialog = jOptionPane.createDialog(new JFrame(), "title");
        dialog.setSize(200, 200);
        dialog.setVisible(true);
      }
}
