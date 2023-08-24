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

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.JTextArea;
import javax.swing.SwingWorker;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.clients.admin.DescribeClusterResult;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.Node;

import rafael.alcocer.caldera.kafka.swing.service.AdminSingleton;
import rafael.alcocer.caldera.kafka.swing.utils.LabelUtils;

public class DescribeClusterWorker extends SwingWorker<DescribeClusterResult, Void> {

    private final JTextArea textArea;
    private final String clusterId;

    public DescribeClusterWorker(JTextArea textArea, String clusterId) {
        this.textArea = textArea;
        this.clusterId = clusterId;
    }

    @Override
    protected DescribeClusterResult doInBackground() throws Exception {
        return describeCluster();
    }

    @Override
    protected void done() {
        textArea.updateUI();
    }

    private DescribeClusterResult describeCluster() throws Exception {
        Admin admin = AdminSingleton.getAdmin();

        DescribeClusterResult result = admin.describeCluster();
        KafkaFuture<Collection<Node>> nodes = result.nodes();
        Collection<Node> nodeCollection = result.nodes().get();

        System.out.println("##### admin.metrics(): " + admin.metrics());
        System.out.println("##### result: " + result);
        System.out.println("##### result.clusterId(): " + result.clusterId());
        System.out.println("##### result.clusterId().get(): " + result.clusterId().get());
        System.out.println("##### nodes: " + nodes);
        System.out.println("##### nodeCollection (Broker): " + nodeCollection);

        // try {
        List<Integer> brokers = admin.describeCluster().nodes().get().stream().map(Node::id)
                .collect(Collectors.toList());

        System.out.println("##### brokers: " + brokers);
        System.out.println("##### broker.id: " + brokers.get(0));

        brokers.forEach(x -> System.out.println("##### Integer: " + x));
        // } catch (InterruptedException | ExecutionException e1) {
        // TODO Auto-generated catch block
        // e1.printStackTrace();
        // }

        textArea.setText(LabelUtils.CLUSTER_DESCRIPTION);
        textArea.append(System.lineSeparator());
        textArea.append("--------------------");
        textArea.append(System.lineSeparator());
        textArea.append("" + result.clusterId());
        textArea.append(System.lineSeparator());
        textArea.append("" + result.clusterId().get());
        textArea.append(System.lineSeparator());
        textArea.append(System.lineSeparator());
        textArea.append(LabelUtils.TOTAL_OF_BROKERS + nodeCollection.size());
        textArea.append(System.lineSeparator());
        textArea.append("--------------------");
        textArea.append(System.lineSeparator());
        textArea.append(System.lineSeparator());

        nodeCollection.stream().forEach(broker -> {
            textArea.append(LabelUtils.BROKER + broker);
            textArea.append(System.lineSeparator());
            textArea.append(LabelUtils.HOST + broker.host());
            textArea.append(System.lineSeparator());
            textArea.append(LabelUtils.PORT + broker.port());
            textArea.append(System.lineSeparator());
            textArea.append(LabelUtils.ID + broker.idString());
            textArea.append(System.lineSeparator());
            textArea.append(LabelUtils.RACK + broker.rack());
        });

        textArea.append(System.lineSeparator());

        return result;
    }
}
