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

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.utils.FontUtils;

@Data
public class MenuPanel extends JPanel {

    private JMenuItem configurationMenuItem;
    private JMenuItem clustersMenuItem;
    private JMenuItem createTopicMenuItem;
    private JMenuItem deleteTopicMenuItem;
    private JMenuItem listTopicsMenuItem;
    private JMenuItem menuItemSalir;

    private JMenu configurationMenu;
    private JMenu clustersMenu;
    private JMenu topicsMenu;
    private JMenu menuSalir;

    private JMenuBar menuBar;

    public MenuPanel() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        setLayout(null);
        setBackground(Color.LIGHT_GRAY);
        setBounds(10, 10, screenSize.width - 20, 70);

        configurationMenuItem = new JMenuItem();
        configurationMenuItem.setFont(FontUtils.VERDANA_BOLD_18);
        configurationMenuItem.setText("Configuration");
        configurationMenuItem.setVisible(true);

        configurationMenu = new JMenu("Configuration");
        configurationMenu.setFont(FontUtils.VERDANA_BOLD_18);
        configurationMenu.add(configurationMenuItem);

        clustersMenuItem = new JMenuItem();
        clustersMenuItem.setFont((FontUtils.VERDANA_BOLD_18));
        clustersMenuItem.setText("Clusters");
        clustersMenuItem.setVisible(true);

        clustersMenu = new JMenu("Clusters");
        clustersMenu.setFont((FontUtils.VERDANA_BOLD_18));
        clustersMenu.add(clustersMenuItem);

        createTopicMenuItem = new JMenuItem();
        createTopicMenuItem.setFont((FontUtils.VERDANA_BOLD_18));
        createTopicMenuItem.setText("Create Topic");
        createTopicMenuItem.setVisible(true);

        deleteTopicMenuItem = new JMenuItem();
        deleteTopicMenuItem.setFont((FontUtils.VERDANA_BOLD_18));
        deleteTopicMenuItem.setText("Delete Topic");
        deleteTopicMenuItem.setVisible(true);

        listTopicsMenuItem = new JMenuItem();
        listTopicsMenuItem.setFont(FontUtils.VERDANA_BOLD_18);
        listTopicsMenuItem.setText("List Topics");
        listTopicsMenuItem.setVisible(true);

        topicsMenu = new JMenu("Topics");
        topicsMenu.setFont(FontUtils.VERDANA_BOLD_18);
        topicsMenu.add(createTopicMenuItem);
        topicsMenu.add(deleteTopicMenuItem);
        topicsMenu.add(listTopicsMenuItem);

        menuItemSalir = new JMenuItem();
        menuItemSalir.setFont(FontUtils.VERDANA_BOLD_18);
        menuItemSalir.setText("Salir");

        menuSalir = new JMenu("Salir");
        menuSalir.setFont(FontUtils.VERDANA_BOLD_18);
        menuSalir.add(menuItemSalir);

        menuBar = new JMenuBar();
        menuBar.setBounds(10, 10, screenSize.width - 40, 50);
        menuBar.add(configurationMenu);
        menuBar.add(clustersMenu);
        menuBar.add(topicsMenu);
        menuBar.add(menuSalir);

        add(menuBar);
    }
}
