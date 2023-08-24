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
package rafael.alcocer.caldera.kafka.swing.service;

import java.util.Properties;

import org.apache.kafka.clients.admin.Admin;
import org.apache.kafka.streams.StreamsConfig;

import rafael.alcocer.caldera.kafka.swing.model.Configuration;

public class ConfigurationServiceImpl implements ConfigurationService {

    private static final AdminService adminService = new AdminServiceImpl();

    @Override
    public Admin saveConfiguration(Configuration configuration) {
        Properties props = new Properties();
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, configuration.getApplicationId());
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, configuration.getBootstrapServers());

        Admin admin = adminService.createAdmin(props);

        AdminSingleton.getInstance(admin);

        return AdminSingleton.getAdmin();
    }
}
