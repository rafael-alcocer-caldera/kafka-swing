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
package rafael.alcocer.caldera.kafka.swing.controller;

import org.apache.kafka.clients.admin.Admin;

import rafael.alcocer.caldera.kafka.swing.model.Configuration;
import rafael.alcocer.caldera.kafka.swing.service.ConfigurationService;
import rafael.alcocer.caldera.kafka.swing.service.ConfigurationServiceImpl;

public class ConfigurationControllerImpl implements ConfigurationController {

    private final ConfigurationService configurationService = new ConfigurationServiceImpl();

    @Override
    public Admin saveConfiguration(Configuration configuration) {
        return configurationService.saveConfiguration(configuration);
    }
}
