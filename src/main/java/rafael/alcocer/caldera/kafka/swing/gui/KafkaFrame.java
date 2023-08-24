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

import java.util.Properties;
import java.util.UUID;

import javax.swing.JFrame;

import lombok.Data;
import rafael.alcocer.caldera.kafka.swing.listeners.CancelConfigurationActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.CreateTopicActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.DeleteTopicActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.DescribeClustersActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.DescribeTopicSelectionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.ListClustersActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.ListTopicsActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.SalirActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.SaveConfigurationActionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.SelectToDeleteTopicSelectionListener;
import rafael.alcocer.caldera.kafka.swing.listeners.SetComponentVisibleActionListener;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

@Data
public class KafkaFrame extends JFrame {

    private MenuPanel menuPanel;
    private ConfigurationPanel configurationPanel;
    private ClustersPanel clustersPanel;
    private CreateTopicPanel createTopicPanel;
    private DeleteTopicPanel deleteTopicPanel;
    private ListTopicsPanel listTopicsPanel;
    private ResultPanel configurationResultPanel;
    private ResultPanel clustersResultPanel;
    private ResultPanel createTopicResultPanel;
    private ResultPanel deleteTopicResultPanel;
    private ResultPanel listTopicsResultPanel;
    private GenericLayoutSplitPane configurationSplitPane;
    private GenericLayoutSplitPane clustersSplitPane;
    private GenericLayoutSplitPane createTopicSplitPane;
    private GenericLayoutSplitPane deleteTopicsSplitPane;
    private GenericLayoutSplitPane listTopicsSplitPane;
    private Properties props = new Properties();

    public KafkaFrame() {
        menuPanel = new MenuPanel();
        menuPanel.setVisible(true);

        createConfigurationPanels();
        createClustersPanels();
        createTopicPanels();
        createSplitPanes();

        setSplitPanesVisible(false);

        menuPanel.getConfigurationMenuItem()
                .addActionListener(new SetComponentVisibleActionListener(configurationSplitPane, this));
        menuPanel.getClustersMenuItem()
                .addActionListener(new SetComponentVisibleActionListener(clustersSplitPane, this));
        menuPanel.getCreateTopicMenuItem()
                .addActionListener(new SetComponentVisibleActionListener(createTopicSplitPane, this));
        menuPanel.getDeleteTopicMenuItem()
                .addActionListener(new SetComponentVisibleActionListener(deleteTopicsSplitPane, this));
        menuPanel.getListTopicsMenuItem()
                .addActionListener(new SetComponentVisibleActionListener(listTopicsSplitPane, this));
        menuPanel.getMenuItemSalir().addActionListener(new SalirActionListener(this));

        add(menuPanel);
        add(configurationSplitPane);
        add(clustersSplitPane);
        add(createTopicSplitPane);
        add(deleteTopicsSplitPane);
        add(listTopicsSplitPane);

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setTitle(LabelUtils.KAFKA);
        setLayout(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();
    }

    public void cleanConfigurationPanel() {
        configurationPanel.getApplicationIdTextfield().setText("");
        configurationPanel.getBootstrapServersTextfield().setText("");
    }

    public void cleanConfigurationPanelAll() {
        cleanConfigurationPanel();

        configurationResultPanel.getTextArea().setText("");
    }

    public void cleanDeleteTopicPanel() {
        deleteTopicPanel.getLabel().setText("");
        deleteTopicPanel.getModel().clear();
        deleteTopicPanel.getTopicNameTextfield().setText("");
        deleteTopicResultPanel.getTextArea().setText("");
    }

    public void cleanListTopicsPanel() {
        listTopicsPanel.getLabel().setText("");
        listTopicsPanel.getModel().clear();
        listTopicsResultPanel.getTextArea().setText("");
    }

    public void setConfigurationPanelDefaultValues() {
        configurationPanel.getApplicationIdTextfield().setText("" + UUID.randomUUID());
        configurationPanel.getBootstrapServersTextfield().setText("localhost:9092");
    }

    public void setSplitPanesVisible(boolean aFlag) {
        configurationSplitPane.setVisible(aFlag);
        clustersSplitPane.setVisible(aFlag);
        createTopicSplitPane.setVisible(aFlag);
        deleteTopicsSplitPane.setVisible(aFlag);
        listTopicsSplitPane.setVisible(aFlag);
    }

    private void createConfigurationPanels() {
        configurationPanel = new ConfigurationPanel();
        configurationPanel.getBootstrapServersTextfield().setToolTipText(LabelUtils.BOOTSTRAP_SERVER);
        configurationPanel.getConnectButton().addActionListener(new SaveConfigurationActionListener(this));
        configurationPanel.getCancelButton().addActionListener(new CancelConfigurationActionListener(this));

        configurationResultPanel = new ResultPanel();
    }

    private void createClustersPanels() {
        clustersResultPanel = new ResultPanel();

        clustersPanel = new ClustersPanel();
        clustersPanel.getList()
                .addListSelectionListener(new DescribeClustersActionListener(clustersResultPanel.getTextArea()));
        clustersPanel.getButton().addActionListener(new ListClustersActionListener(clustersPanel.getModel(),
                clustersPanel.getList(), clustersPanel.getLabel()));
    }

    private void createTopicPanels() {
        createTopicResultPanel = new ResultPanel();
        createTopicPanel = new CreateTopicPanel();
        createTopicPanel.getSaveButton().addActionListener(new CreateTopicActionListener(this));

        deleteTopicResultPanel = new ResultPanel();
        deleteTopicPanel = new DeleteTopicPanel();
        deleteTopicPanel.getDeleteButton().addActionListener(new DeleteTopicActionListener(this));
        deleteTopicPanel.getList().addListSelectionListener(
                new SelectToDeleteTopicSelectionListener(deleteTopicPanel.getTopicNameTextfield()));
        deleteTopicPanel.getButton().addActionListener(new ListTopicsActionListener(deleteTopicPanel.getModel(),
                deleteTopicPanel.getList(), deleteTopicPanel.getLabel()));

        listTopicsResultPanel = new ResultPanel();
        listTopicsPanel = new ListTopicsPanel();
        listTopicsPanel.getList()
                .addListSelectionListener(new DescribeTopicSelectionListener(listTopicsResultPanel.getTextArea()));
        listTopicsPanel.getButton().addActionListener(new ListTopicsActionListener(listTopicsPanel.getModel(),
                listTopicsPanel.getList(), listTopicsPanel.getLabel()));
    }

    private void createSplitPanes() {
        configurationSplitPane = new GenericLayoutSplitPane(configurationPanel, configurationResultPanel);
        clustersSplitPane = new GenericLayoutSplitPane(clustersPanel, clustersResultPanel);
        createTopicSplitPane = new GenericLayoutSplitPane(createTopicPanel, createTopicResultPanel);
        deleteTopicsSplitPane = new GenericLayoutSplitPane(deleteTopicPanel, deleteTopicResultPanel);
        listTopicsSplitPane = new GenericLayoutSplitPane(listTopicsPanel, listTopicsResultPanel);
    }
}
