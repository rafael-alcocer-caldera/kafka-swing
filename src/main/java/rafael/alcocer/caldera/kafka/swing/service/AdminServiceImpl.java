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

public class AdminServiceImpl implements AdminService {
    
    private Admin admin;
    
    @Override
    public Admin createAdmin(Properties props) {
        admin = Admin.create(props);
        
        return admin;
    }

    @Override
    public Admin getAdmin() {
        return admin;
    }
}
