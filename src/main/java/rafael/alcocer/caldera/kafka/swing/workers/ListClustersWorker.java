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
package rafael.alcocer.caldera.kafka.swing.workers;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingWorker;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.DescribeClusterResult;

import rafael.alcocer.caldera.kafka.swing.service.AdminSingleton;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

public class ListClustersWorker extends SwingWorker<DescribeClusterResult, Void> {

    private final DefaultListModel<String> model;
    private final JList<String> list;
    private final JLabel label;

    public ListClustersWorker(DefaultListModel<String> model, JList<String> list, JLabel label) {
        this.model = model;
        this.list = list;
        this.label = label;

        label.setText("");
        model.clear();
    }

    @Override
    protected DescribeClusterResult doInBackground() throws Exception {
        Admin admin = AdminSingleton.getAdmin();

        DescribeClusterResult result = admin.describeCluster();

        model.addElement(result.clusterId().get());

        label.setText(LabelUtils.TOTAL_OF_CLUSTERS + model.getSize());

        return result;
    }

    @Override
    protected void done() {
        list.updateUI();
    }
}
